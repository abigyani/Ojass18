package in.nitjsr.ojass.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import in.nitjsr.ojass.Activities.DevelopersAcitivity;
import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.Constants;
import in.nitjsr.ojass.Utils.Utilities;

/**
 * Created by Abhishek on 03-Feb-18.
 */

public class DevRVAdapter extends RecyclerView.Adapter<DevRVAdapter.Myviewholder> {

    private Context context;
    private static final String[] githubLink = new String[]{
            "https://github.com/abigyani",
            "https://github.com/Roushan073",
            "https://github.com/adikumar25",
            "https://github.com/shivamsmarty",
            "https://github.com/raj61",
            "https://www.github.com/aditya314",
            "https://github.com/ravi9598",
            "https://github.com/anirudh1107",
            "https://github.com/",
            "https://github.com/Saanayy",
            "https://github.com/gasaha123",
            "https://github.com/utkarshh12",
            "https://github.com/developershubh13"
    };
    private static final String[] fbLink = new String[] {
            "https://www.facebook.com/ak47gyani",
            "https://www.facebook.com/profile.php?id=100005336597333",
            "https://www.facebook.com/imcooladitya.kumar",
            "https://www.facebook.com/shivam.srivastava.1610",
            "https://www.facebook.com/imrajranjan",
            "https://www.facebook.com/anksshady",
            "https://www.facebook.com/ravip9598",
            "https://www.facebook.com/anirudh.deep.5",
            "https://www.facebook.com/",
            "https://www.facebook.com/Fake.aarav",
            "https://www.facebook.com/gaurav.sethi.102",
            "https://www.facebook.com/utkarshh12",
            "https://www.facebook.com/profile.php?id=100008461894976"
    };
    private static final String[] whatsApp = new String[] {
            "7858030449",
            "9155956813",
            "7870517024",
            "9470918557",
            "8507118002",
            "9534291132",
            "9771179116",
            "8565950269",
            "8102226243",
            "8986739905",
            "7351530721",
            "9430784173",
            "7484918476"
    };

    private static final String[] linkedIn = new String[] {
            "https://www.linkedin.com/in/abhishek-kumar-1706/",
            "https://www.linkedin.com/in/roushan-kumar-891200124/",
            "https://www.linkedin.com/in/aditya-k-a62b12a5/",
            "https://www.linkedin.com/in/shivam-srivastava-70a644131/",
            "https://www.linkedin.com/in/raj-ranjan-72014754/",
            "https://www.linkedin.com/in/aditya-nihal-kumar-singh-403799112/",
            "https://www.linkedin.com/in/ravi-prakash-654b0a112",
            "https://www.linkedin.com/in/anirudh-deep-642863144",
            "https://www.linkedin.com/in/",
            "https://www.linkedin.com/in/sanay-dev-817aa8147/",
            "https://www.linkedin.com/in/gaurav-sethi-176a80138/",
            "https://www.linkedin.com/in/utkarsh-kulshrestha-40b37a122",
            "https://www.linkedin.com/in/shubham-kumar-a44b76158"
    };

    private static final String[] names = new String[]{
            "Abhishek Kumar",
            "Roushan Kumar",
            "Aditya Kumar",
            "Shivam Srivastava",
            "Raj Ranjan",
            "Aditya Nihal",
            "Ravi Prakash",
            "Anirudh Deep",
            "Kumar Naman",
            "Sanay Dev",
            "Gaurav Sethi",
            "Utkarsh Kumar",
            "Shubham Kumar"
    };

    private static final String[] emails = new String[]{
            "abhishek1706@hotmail.com",
            "roushankumar.nit@gmail.com",
            "adi.15j13@gmail.com",
            "shivamnitjsr28@gmail.com",
            "raj18021997@gmail.com",
            "anksshady@gmail.com",
            "raviprakash9598@gmail.com",
            "anirudhdeep.11@gmail.com",
            "example@gmail.com",
            "sanay.nitjsr@gmail.com",
            "gaurav.sethi32@gmail.com",
            "utkarshh12@gmail.com",
            "developershubh13@gmail.com"
    };

    private static final String[] desc = new String[]{
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2015-2019",
            "Electronics & Communication Engg.\nB.Tech. (Hons.)\n2015-2019",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2016-2020",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2016-2020",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2016-2020",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2016-2020",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2016-2020",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2016-2020"
    };

    private static final String[] images = new String[] {
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/AppDevImages%2Fabhishek2.jpg?alt=media&token=4d93fd34-7517-4abe-82e9-88126836a8c2",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/AppDevImages%2Froushan.png?alt=media&token=67aa2688-0caf-454e-8678-3161f9eacae9",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/AppDevImages%2Faditya.png?alt=media&token=c19148d8-9fc0-4e86-9ea8-5a69fdd722a9",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/AppDevImages%2Fshivam.png?alt=media&token=d242014a-069d-465f-b865-6542bb0a6e9f",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/AppDevImages%2Frajbharwa.png?alt=media&token=33642917-8dd1-4621-8ca2-a924cad69a4b",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/AppDevImages%2Fans.png?alt=media&token=a8fe96ca-9c83-4001-8236-768d250c1d7c",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/AppDevImages%2Fic_ravi_app.png?alt=media&token=ca969b77-43c8-4fba-9610-e0c9b55de564",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/AppDevImages%2Fanirudh.png?alt=media&token=1251c5c5-fa49-4149-b0fb-bdb2ce8de273",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/AppDevImages%2Fic_naman_app.png?alt=media&token=264dfb3b-7678-425b-a0ba-8b9731665dd1",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/AppDevImages%2Fsanay.png?alt=media&token=bb579167-0c97-4da9-b3c2-12fa9475da9e",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/AppDevImages%2Fgauravimg.jpeg?alt=media&token=97a26c7c-a7d8-486e-934e-fc24947be6e9",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/AppDevImages%2Futkarsh.png?alt=media&token=14f70e3c-2ab0-46c6-90cf-f067e8c40a7f",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/AppDevImages%2Fshubham.png?alt=media&token=5e3ae633-ac2d-4430-8f66-5612a8d74034"
    };

    public DevRVAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.element_dev_page, parent,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, final int position) {
        holder.name.setText(names[position]);

        Utilities.setPicassoImage(context, images[position], holder.image, Constants.SQUA_PLACEHOLDER);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DevelopersAcitivity.setDevData(images[position], names[position], emails[position], desc[position], linkedIn[position],
                        fbLink[position], githubLink[position], whatsApp[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    class Myviewholder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;

        public Myviewholder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_element_dev_img);
            name = itemView.findViewById(R.id.tv_element_dev_name);
        }

    }
}
