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

/**
 * Created by Abhishek on 03-Feb-18.
 */

public class DevRVAdapter extends RecyclerView.Adapter<DevRVAdapter.Myviewholder> {

    private Context context;
    private static final String[] githubLink = new String[]{
            "https://github.com/abigyani",
            "https://github.com/Roushan073",
            "https://github.com/adikumar25",
            "https://github.com/abigyani",
            "https://github.com/raj61",
            "https://github.com/abigyani",
            "https://github.com/abigyani",
            "https://github.com/abigyani",
            "https://github.com/abigyani",
            "https://github.com/abigyani",
            "https://github.com/abigyani",
            "https://github.com/abigyani"
    };
    private static final String[] fbLink = new String[] {
            "https://www.facebook.com/ak47gyani",
            "https://www.facebook.com/profile.php?id=100005336597333",
            "https://www.facebook.com/imcooladitya.kumar",
            "https://www.facebook.com/ak47gyani",
            "https://www.facebook.com/imrajranjan",
            "https://www.facebook.com/ak47gyani",
            "https://www.facebook.com/ak47gyani",
            "https://www.facebook.com/ak47gyani",
            "https://www.facebook.com/ak47gyani",
            "https://www.facebook.com/ak47gyani",
            "https://www.facebook.com/ak47gyani",
            "https://www.facebook.com/ak47gyani"
    };
    private static final String[] whatsApp = new String[] {
            "7858030449",
            "9155956813",
            "7870517024",
            "7858030449",
            "8507118002",
            "7858030449",
            "7858030449",
            "7858030449",
            "7858030449",
            "7858030449",
            "7858030449",
            "7858030449"
    };

    private static final String[] linkedIn = new String[] {
            "https://www.linkedin.com/in/abhishek-kumar-1706/",
            "https://www.linkedin.com/in/roushan-kumar-891200124/",
            "https://www.linkedin.com/in/aditya-k-a62b12a5/",
            "https://www.linkedin.com/in/abhishek-kumar-1706/",
            "https://www.linkedin.com/in/raj-ranjan-72014754/",
            "https://www.linkedin.com/in/abhishek-kumar-1706/",
            "https://www.linkedin.com/in/abhishek-kumar-1706/",
            "https://www.linkedin.com/in/abhishek-kumar-1706/",
            "https://www.linkedin.com/in/abhishek-kumar-1706/",
            "https://www.linkedin.com/in/abhishek-kumar-1706/",
            "https://www.linkedin.com/in/abhishek-kumar-1706/",
            "https://www.linkedin.com/in/abhishek-kumar-1706/"
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
            "Utkarsh Kumar"
    };

    private static final String[] emails = new String[]{
            "abhishek1706@hotmail.com",
            "roushankumar.nit@gmail.com",
            "adi.15j13@gmail.com",
            "abhishek@buyhatke.com",
            "raj18021997@gmail.com",
            "abhishek@buyhatke.com",
            "abhishek@buyhatke.com",
            "abhishek@buyhatke.com",
            "abhishek@buyhatke.com",
            "abhishek@buyhatke.com",
            "abhishek@buyhatke.com",
            "abhishek@buyhatke.com"
    };

    private static final String[] desc = new String[]{
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018",
            "Computer Science & Engg.\nB.Tech. (Hons.)\n2014-2018"
    };

    private static final int[] images = new int[] {
        R.drawable.portrait,
        R.drawable.portraitthree,
        R.drawable.portraitfour,
        R.drawable.portrait,
        R.drawable.portraitthree,
        R.drawable.portraitfour,
        R.drawable.portrait,
        R.drawable.portraitthree,
        R.drawable.portraitfour,
        R.drawable.portrait,
        R.drawable.portraitthree,
        R.drawable.portraitfour
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

        Picasso.with(context).load(images[position]).fit().into(holder.image);

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


