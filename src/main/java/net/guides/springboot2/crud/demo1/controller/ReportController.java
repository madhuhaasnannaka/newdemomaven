package net.guides.springboot2.crud.demo1.controller;

//import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.TreeMap;
import java.util.Optional;
import java.io.OutputStream;
import java.net.*;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
/*import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;*/
import org.springframework.http.ResponseEntity;
//import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestTemplate;


import net.guides.springboot2.crud.demo1.exception.ResourceNotFoundException;
import net.guides.springboot2.crud.demo1.model.DetailsFromDoctor;
import net.guides.springboot2.crud.demo1.model.DetailsFromOrm;
import net.guides.springboot2.crud.demo1.model.OrmMessageHandlerController;
import net.guides.springboot2.crud.demo1.model.DetailsOfReport;

import net.guides.springboot2.crud.demo1.repository.ReportRepository;
import net.guides.springboot2.crud.demo1.status.Status;
//import subscriber.JmsSubcriber;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


@RestController
//@RequestMapping("/api/v1")
public class ReportController {
	private static final Logger logg=LoggerFactory.getLogger(ReportController.class); 
	/*
	 * @Autowired RestTemplate restTemplate;
	 */
	/*
	 * @Autowired RestTemplate restTemplate;
	 * 
	 * @RequestMapping(value = "/template/products") public String getProductList()
	 * { HttpHeaders headers = new HttpHeaders();
	 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * HttpEntity<String> entity = new HttpEntity<String>(headers);
	 * 
	 * return restTemplate.exchange( "http://localhost:8080/products",
	 * HttpMethod.GET, entity, String.class).getBody(); }
	 */

	@Autowired
	private ReportRepository reportRepository;
	private URL uri;

	@GetMapping("/report/data")
	public @ResponseBody List<DetailsFromOrm> getAllReport() {
		
		return reportRepository.findAll();
		
	}
	
	

	@GetMapping("/report/data/{id}")
	
	public @ResponseBody ResponseEntity<DetailsFromOrm> getReportByid(@PathVariable(value = "id") int id)

			throws ResourceNotFoundException {
		DetailsFromOrm report = reportRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		String val= String.valueOf(report);
		logg.info(val);
		return ResponseEntity.ok().body(report);
	}
	
	
	
	

	@PostMapping("/report")

	@ResponseBody
	public DetailsFromOrm createReport(@Valid @RequestBody DetailsFromOrm report) {
		String str= String.valueOf(report);
		logg.info(str);
		return reportRepository.save(report);
	}

	
	
	
	
	
	// @PutMapping("/report/{id}")
	@RequestMapping(value = "/report/doctor/{id}", method = RequestMethod.PUT)
	public ResponseEntity<DetailsFromOrm> updateReport(@PathVariable(value = "id") int id,
			@Valid @RequestBody DetailsFromOrm reportDetails) throws ResourceNotFoundException {
		DetailsFromOrm report = reportRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		Status status = new Status();
		report.setstatus(status.StatusGenerator(id));
		// report.setEmailId(reportDetails.getEmailId());
		// report.setEqp_Id(reportDetails.getReport_desc());
		// report.setReport_desc(reportDetails.getReport_desc());
		report.setLastName(reportDetails.getLastName());
		report.setFirstName(reportDetails.getFirstName());
		// report.setstatus(reportDetails.getstatus());
		// report.setstatus(status.StatusGenerator());

		final DetailsFromOrm updatedReport = reportRepository.save(report);
		
		return ResponseEntity.ok(updatedReport);
	}

	@DeleteMapping("/report/{d_id}")
	public Map<String, Boolean> deleteReport(@PathVariable(value = "d_id") int d_id) throws ResourceNotFoundException {
		DetailsFromOrm report = reportRepository.findById(d_id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + d_id));

		reportRepository.delete(report);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		String convert= String.valueOf(response);
		logg.info(convert);
		return response;
	}

	//@RequestMapping(value = "/report/orm/{doctorid}/patient/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	/*//doc id-pat id storing
	 * Accept=application/json;"
	 */	
	//@ResponseBody
	
	
	
	
	
	
	
	
	
	
	
	  @GetMapping("orm/Report/{doctorid}") 
	public DetailsFromOrm getDetails(@PathVariable("doctorid") int doctorid/* , @PathVariable("id") String id */ ) throws
	  ResourceNotFoundException {
	 //System.out.println("Hello"); 
	 RestTemplate restTemplate = new RestTemplate(); 
	 //System.out.print("as"); 
	 // ResponseEntity<DetailsFromBooking>responseEntity= 
	 
         String url= "http://192.168.6.57:9999/orm/OrmMessageHandler/Report/PATID12";
		/*
		 * URL url=null; url=new URL(uri); HttpURLConnection.connection =
		 * (HttpURLConnection) url.openConnection();
		 */
	 //JmsSubcriber js = null;
	 //String str= js.receive(id);
	 //System.out.println(str);
			 
	  ResponseEntity<DetailsFromOrm> response =restTemplate.getForEntity(url,DetailsFromOrm.class); 
	  
	  // getForObject(String url,Class<T> responseType, Map<String,?> uriVariables)
	  //System.out.print(response.getBody().getId()); 
	  // DetailsFromBooking response= responseEntity.getBody();
	  
	  DetailsFromOrm report = reportRepository.findById(doctorid) .orElseThrow(() -> new
	  ResourceNotFoundException("Employee not found for this id :: " + doctorid));
	  // Report report = reportRepository.findById(id);
	  
	 // String str = null;
		/* report.setID(JmsSubcriber.receive(str)); */
	report.setID(response.getBody().getID());
	  reportRepository.save(report);
	  return report;
	 
	
	
	
	
	
	 /* String uri =
			      "http://localhost:8080/CustomerService/rest/customers/1";
			  URL url = new URL(uri);
			  HttpURLConnection connection =
			      (HttpURLConnection) url.openConnection();
			  connection.setRequestMethod("GET");
			  connection.setRequestProperty("Accept", "application/xml");

			  JAXBContext jc = JAXBContext.newInstance(Customer.class);
			  InputStream xml = connection.getInputStream();
			  Customer customer =
			      (Customer) jc.createUnmarshaller().unmarshal(xml);

			  connection.disconnect(); 
			  */
		
		
		
		
			  
			  
			  
			  
			 /* HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
				OutputStream response1 = conn.getOutputStream();
				
				Report report1 = reportRepository.findById(doctorid) .orElseThrow(() -> new
						  ResourceNotFoundException("Employee not found for this id :: " + doctorid));
				
				report1.setId(response1.getBody().getId()); //
				  //report1.setBookingId(response1.getBookingId()); 
				  reportRepository.save(report1);
				  return report1;
				
				response1.write(parameter.getBytes());
				response1.flush();

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));//

				String output;  
			  
			 */ 
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
		
		
		
		
		
		
		
		
		
		/*
		 * UserDetails userDetails1=new
		 * org.springframework.security.core.userdetails.User(response.getEmailAddress()
		 * , response.getPassword(), new ArrayList<>()); User userDetails =
		 * userService.verifyLogin(userDetails1.getUsername());
		 * if(userDetails.getActive()=="active") { userDetails.setActive("inactive");
		 * final User updatedUser = userRepository.save(userDetails); return
		 * "Successfully logged out"; } else { return "Failed to logout"; }
		 */
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET, value
	 * ="/report/doctor/{d_id}",produces=MediaType.APPLICATION_JSON_VALUE), consumes
	 * = MediaType.APPLICATION_FORM_URLENCODED_VALUE,produces=MediaType.
	 * APPLICATION_JSON_VALUE, headers = "Accept=application/json"
	 */

	/*
	 * @ResponseBody public Report getDetails1(@PathVariable("d_id") int d_id)
	 * throws ResourceNotFoundException {
	 * 
	 * 
	 * 
	 * 
	 * RestTemplate restTemplate = new RestTemplate();
	 * 
	 * 
	 * 
	 * 
	 * //ResponseEntity<DetailsFromBooking> responseEntity=
	 * 
	 * DetailsFromDoctor response= restTemplate.
	 * getForObject("https://localhost:44382/api/OrmMessageHandler/Report/{id} "
	 * ,DetailsFromDoctor.class);
	 * 
	 * //DetailsFromBooking response = responseEntity.getBody();
	 * 
	 * 
	 * Report report =reportRepository.findById(d_id) .orElseThrow(() -> new
	 * ResourceNotFoundException("Employee not found for this id :: " +d_id));
	 * //Report report = reportRepository.findById(id);
	 * 
	 * report.setstatus(response.getStatus()); //
	 * report.setBookingId(response.getBookingId()); reportRepository.save(report);
	 * return report;
	 * 
	 * 
	 * 
	 * UserDetails userDetails1=new
	 * org.springframework.security.core.userdetails.User(response.getEmailAddress()
	 * , response.getPassword(), new ArrayList<>()); User userDetails =
	 * userService.verifyLogin(userDetails1.getUsername());
	 * if(userDetails.getActive()=="active") { userDetails.setActive("inactive");
	 * final User updatedUser = userRepository.save(userDetails); return
	 * "Successfully logged out"; } else { return "Failed to logout"; }
	 * 
	 * }
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/report/doctor/{id}", produces = MediaType.APPLICATION_JSON_VALUE) 
	/* Accept=application/json" */
	@ResponseBody
	public DetailsFromOrm getDetails1(@PathVariable("id") int doctorid) throws ResourceNotFoundException {

		RestTemplate restTemplate = new RestTemplate();

		// ResponseEntity<DetailsFromBooking> responseEntity=

		DetailsFromDoctor response = restTemplate.getForObject("http://localhost:8088/userId ",
				DetailsFromDoctor.class);

		// DetailsFromBooking response = responseEntity.getBody();

		DetailsFromOrm report = reportRepository.findById(doctorid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + doctorid));
		// Report report = reportRepository.findById(id);

		report.setstatus(response.getStatus());
		// report.setBookingId(response.getBookingId());
		reportRepository.save(report);
		return report;

	}

	/*
	 * @RequestMapping(value = "/send/{id}", method = RequestMethod.GET, produces =
	 * MediaType.APPLICATION_JSON_VALUE consumes = MediaType.APPLICATION_JSON_VALUE
	 * )
	 * 
	 * @ResponseBody public DetailsOfReport getCatalog(@PathVariable int id) throws
	 * ResourceNotFoundException {
	 * 
	 * Report report = reportRepository.findById(id).orElseThrow(() -> new
	 * ResourceNotFoundException("Employee not found for this id :: " + id));
	 * 
	 * DetailsOfReport details = new DetailsOfReport();
	 * details.setId(report.getId());
	 * 
	 * return details; }
	 */

}