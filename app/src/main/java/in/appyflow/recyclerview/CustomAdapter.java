package in.appyflow.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{

    ArrayList<Employee> list,tempList;


    public CustomAdapter(ArrayList<Employee> list) {
        this.list = list;
        tempList=new ArrayList<>();
        tempList.addAll(list);
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        Employee employee=list.get(position);
        holder.name.setText(employee.name);
        holder.phone.setText(employee.phone);
        holder.address.setText(employee.address);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filter(String searchQuery) {

        list.clear();
        if(searchQuery.length()>0){

            for(Employee item:tempList){

                if(item.name.toLowerCase().contains(searchQuery.toLowerCase() )||item.phone.toLowerCase().contains(searchQuery.toLowerCase())){
                    list.add(item);
                }

            }


        }else{

            list.addAll(tempList);

        }

        notifyDataSetChanged();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{


        TextView name,phone,address;

        public CustomViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            phone=itemView.findViewById(R.id.phone);
            address=itemView.findViewById(R.id.address);
        }
    }

}
