package five;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Main {
    public static void main(String args[]) {
        List<Car> arrayList = new ArrayList<>();
        arrayList.add(new Car("Ford",10,223));
        arrayList.add(new Car("Hyundai",4,210));
        arrayList.add(new Car("Jeep",2,267));
        arrayList.add(new Car("Lada",12,200));

        Gson gson = new Gson();
        String json = gson.toJson(arrayList);

        System.out.println(json);
    }
}