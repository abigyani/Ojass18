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
            "https://github.com/aditya314",
            "https://github.com/ravi9598",
            "https://github.com/anirudh1107",
            "https://github.com/naman7kr",
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
            "https://www.facebook.com/kumar.naman.707",
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
            "https://www.linkedin.com/in/kumar-naman-55b356128",
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
            "Utkarsh Kulshrestha",
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
            "naman7kr@gmail.com",
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
            "http://www.ojass.in/app/Images/Dev/ahishek.jpg",
            "http://www.ojass.in/app/Images/Dev/roushan.png",
            "http://www.ojass.in/app/Images/Dev/aditya.png",
            "http://www.ojass.in/app/Images/Dev/shivam.png",
            "http://www.ojass.in/app/Images/Dev/rajbharwa.png",
            "http://www.ojass.in/app/Images/Dev/ans.png",
            "http://www.ojass.in/app/Images/Dev/ravi1.jpg",
            "http://www.ojass.in/app/Images/Dev/anirudh.png",
            "http://www.ojass.in/app/Images/Dev/naman.jpg",
            "http://www.ojass.in/app/Images/Dev/sanay.png",
            "http://www.ojass.in/app/Images/Dev/gaurav.jpeg",
            "http://www.ojass.in/app/Images/Dev/utkarsh.jpg",
            "http://www.ojass.in/app/Images/Dev/shubham.png"
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
