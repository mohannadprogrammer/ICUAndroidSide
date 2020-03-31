package fox.com.ajouey.icubookingapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.Context.MODE_PRIVATE;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> hospital = new ArrayList<>();
    private ArrayList<String> typs = new ArrayList<>();
    private ArrayList <Float> prices = new ArrayList<>();
    private ArrayList<String> ids = new ArrayList<>();


    private Context mContext;
    private MainActivity main ;

    public RecyclerViewAdapter(ArrayList<String> hospital, ArrayList<String> typs,ArrayList<Float> prices,ArrayList<String> ids, Context mContext) {
        this.hospital = hospital;
        this.typs=typs;
        this.prices =prices;
        this.mContext = mContext;
        this.ids=ids;
    }
    public RecyclerViewAdapter(ArrayList<String> hospital, ArrayList<String> typs,ArrayList<Float> prices,
                               ArrayList<String> ids, MainActivity main) {
        this.hospital = hospital;
        this.typs=typs;
        this.prices =prices;
        this.main = main;
        this.ids=ids;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.room,viewGroup,false);
        RecyclerViewAdapter.ViewHolder viewHolder = new RecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.hospital.setText(hospital.get(i));
        viewHolder.type.setText(typs.get(i));
        viewHolder.price.setText(prices.get(i).toString());

        viewHolder.booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = mContext.getSharedPreferences("save",MODE_PRIVATE);
                String userid =preferences.getString("userID",null);
                if(userid==null){
                    Toast.makeText(mContext, "قم بتسجيل الدخول اولا", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (mContext,LoginActivity.class);
                    mContext.startActivity(intent);
                }else{
                    BackgroundTask req = new BackgroundTask(mContext);
                    req.execute("booking",userid,""+ids.get(i));


                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return hospital.size();
    }
    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView hospital ;
        TextView type;
        TextView price;
        Button booking ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hospital=(TextView)itemView.findViewById(R.id.hospital);
            type=(TextView)itemView.findViewById(R.id.type);
            price=(TextView)itemView.findViewById(R.id.price);
            booking =(Button )itemView.findViewById(R.id.booking);

        }
    }
}
