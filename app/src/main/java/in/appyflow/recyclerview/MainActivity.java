package in.appyflow.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editText;
    Employee john;
    CustomAdapter customAdapter;
    ArrayList<Employee> employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employees=new ArrayList<>();

        john=new Employee("John","9022309243","South Shores");

        employees.add(john);
        employees.add(new Employee("Jennie","66769669","East Shores"));
        employees.add(new Employee("John","89898789788","North Shores"));
        employees.add(new Employee("Siri","99765765777","West Shores"));
        employees.add(new Employee("Google","9999999999","South Shores"));
        employees.add(new Employee("Bixby","23213192399","South Shores"));


        editText=findViewById(R.id.searchQuery);

        customAdapter=new CustomAdapter(employees);

        recyclerView=findViewById(R.id.serachExample);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(customAdapter);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                customAdapter.filter(s.toString());


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                employees.remove(john);
                customAdapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
