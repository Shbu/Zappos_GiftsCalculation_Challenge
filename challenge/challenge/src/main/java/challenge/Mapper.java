package challenge;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class Mapper {
	
	ObjectMapper mapper = new ObjectMapper();
	
	public void readJsonFormat(String jsonValue){

		try {
			FinalResults finalResults = new FinalResults();
			//List<FinalResults> readValues=mapper.readValue(jsonValue, new TypeReference<List<FinalResults>>(){});
			finalResults=mapper.readValue(jsonValue, FinalResults.class);
			System.out.println("finalResults" +finalResults.getStatusCode());
			/*int statusCode =readValues.getStatusCode();
			System.out.println(statusCode);*/
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
