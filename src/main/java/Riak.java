import domain.Person;
import domain.PersonUpdate;
import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.core.query.Location;

import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;


/**
 * @author sadowsm3 on 17.06.2018
 */

public class Riak {
    public static void main(String[] args) throws UnknownHostException, ExecutionException, InterruptedException {

        System.out.println("GENERATING CLIENT...");

        //using protocol buffer interface for interaction with riak.

        RiakClient riakClient = RiakClient.newClient(8087, "127.0.0.1");
        System.out.println("CLIENT GENERATED SUCCESSFULLY!");
        RiakFunctions.performPreRunCleanup(riakClient);
        Location testResourceKey = RiakFunctions.generateLocationForKey("Test");

        //Creating new resource for storing
        System.out.println("CREATING NEW RESOURCE:");
        Person person = new Person();
        person.setId("6");
        person.setFirstName("Test");
        person.setLastName("McTest");
        person.setBorn(2018);
        person.setSalary(9999.99f);
        System.out.println(person.toString());
        System.out.println(RiakFunctions.addNewEntryWithKey(riakClient, testResourceKey, person));
        RiakFunctions.printEmptyLine();

        //Fetching object from database
        System.out.println("ATTEMPTING TO RETRIEVE OBJECT.. ");
        System.out.println(RiakFunctions.getValueForKey(riakClient, testResourceKey));
        RiakFunctions.printEmptyLine();

        //Updating the object with new values
        System.out.println("UPDATE RESOURCE WITH NEW VALUES");
        PersonUpdate update = new PersonUpdate(null, "NewFirstName", "NewLastName", 2017, 789f);
        System.out.println(RiakFunctions.modifyEntryByKey(riakClient,testResourceKey ,update));
        RiakFunctions.printEmptyLine();

        //Fetching updated resource from the database
        System.out.println("NEW RESOURCE VALUES AS TAKEN FROM RIAK: ");
        System.out.println(RiakFunctions.getValueForKey(riakClient, testResourceKey).toString());
        RiakFunctions.printEmptyLine();

        //Deleting resource
        System.out.println("DELETING NEW RESOURCE! ");
        RiakFunctions.deleteEntryForKey(riakClient, testResourceKey);
        RiakFunctions.printEmptyLine();


        //Attempting to fetch object from the database, throw exception if not found
        System.out.println("ATTEMPTING TO RETRIEVE OBJECT.. ");
        System.out.println(RiakFunctions.getValueForKey(riakClient, testResourceKey));
        RiakFunctions.printEmptyLine();
        riakClient.shutdown();
    }
}
