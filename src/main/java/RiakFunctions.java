import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.commands.kv.DeleteValue;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.api.commands.kv.StoreValue;
import com.basho.riak.client.api.commands.kv.UpdateValue;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;
import domain.Person;
import domain.PersonUpdate;

import java.util.concurrent.ExecutionException;

/**
 * @author sadowsm3 on 17.06.2018
 */
public class RiakFunctions {

    public static String BUCKET_NAME = "s17983";

    public static Person getValueForKey(RiakClient client, Location location) throws ExecutionException, InterruptedException {
        FetchValue fv = new FetchValue.Builder(location).build();
        FetchValue.Response response = client.execute(fv);
        Person p = response.getValue(Person.class);
        if(p != null) {
            return p;
        }
        throw new NoSuchElementException("Element removed/not existing!");
    }

    public static void deleteEntryForKey(RiakClient client, Location key) throws ExecutionException, InterruptedException {
        DeleteValue dv = new DeleteValue.Builder(key).build();
        client.execute(dv);
    }

    public static String addNewEntryWithKey(RiakClient client, Location key, Object itemToStore) throws ExecutionException, InterruptedException {
        StoreValue.Response svResponse;
        if (key != null) {
            StoreValue sv = new StoreValue.Builder(itemToStore).withLocation(key).build();
            svResponse = client.execute(sv);
            return new StringBuffer().append("Resource key: ").append(svResponse.getGeneratedKey().toString()).toString();
        }
        return null;
    }

    public static String modifyEntryByKey(RiakClient client, Location key, PersonUpdate update) throws ExecutionException, InterruptedException {
        UpdateValue updateValue = new UpdateValue.Builder(key).withUpdate(update).build();
        UpdateValue.Response response = client.execute(updateValue);
        return new StringBuffer().append("Was resource updated? ").append(response.wasUpdated()).append(" ").toString();
    }

    public static Location generateLocationForKey(String key) {
        return new Location(new Namespace(BUCKET_NAME), key);
    }

    public static void performPreRunCleanup(RiakClient client) throws ExecutionException, InterruptedException {
        deleteEntryForKey(client, generateLocationForKey("testPerson"));
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
