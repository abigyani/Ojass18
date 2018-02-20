package in.nitjsr.ojass.Utils;

import java.util.ArrayList;
import java.util.List;

import in.nitjsr.ojass.Modals.Team;

/**
 * Created by Abhishek on 28-Jan-18.
 */

public class Constants {

    public static final String NOT_REGISTERED = "Not Registered";
    public static final String PAYMENT_DUE = "Payment Due";

    public static final int EVENT_FLAG = 1;
    public static final int GURU_GYAN_FLAG = 2;
    public static final int SPONSORS_FLAG = 3;

    public static final int RECT_PLACEHOLDER = 0;
    public static final int SQUA_PLACEHOLDER = 1;

    public static final String FIREBASE_REF_USERS = "Users";
    public static final String FIREBASE_REF_EMAIL = "email";
    public static final String FIREBASE_REF_NAME = "name";
    public static final String FIREBASE_REF_PHOTO = "photo";
    public static final String FIREBASE_REF_MOBILE = "mobile";
    public static final String FIREBASE_REF_COLLEGE = "college";
    public static final String FIREBASE_REF_COLLEGE_REG_ID = "regID";
    public static final String FIREBASE_REF_BRANCH = "branch";
    public static final String FIREBASE_REF_TSHIRT_SIZE = "tsirtSize";
    public static final String FIREBASE_REF_OJASS_ID = "ojassID";
    public static final String FIREBASE_REF_TSHIRT = "isTshirt";
    public static final String FIREBASE_REF_KIT = "isKit";

    public static final String FIREBASE_REF_NOTIFICATIONS = "Notifications";
    public static final String FIREBASE_REF_OJASS_CHANNEL = "OJASS";
    public static final String FIREBASE_REF_NOTIFICATIONS_BODY = "ans";
    public static final String FIREBASE_REF_NOTIFICATIONS_TITLE = "question";

    public static final String FIREBASE_REF_POSTERIMAGES = "PosterImages";
    public static final String FIREBASE_REF_IMG_SRC = "img_url";
    public static final String FIREBASE_REF_IMG_CLICK = "click_url";

    public static final String FIREBASE_REF_GURU_GYAN = "GuruGyan";
    public static final String FIREBASE_REF_GURU_GYAN_IMAGE = "image";
    public static final String FIREBASE_REF_GURU_GYAN_LONG_DESC = "longDesc";
    public static final String FIREBASE_REF_GURU_GYAN_SHORT_DESC = "shortDesc";
    public static final String FIREBASE_REF_GURU_GYAN_SHORT_IMAGE = "shortImage";
    public static final String FIREBASE_REF_GURU_GYAN_TITLE = "title";
    public static final String FIREBASE_REF_GURU_GYAN_DATE = "date";

    public static final String[] homeEvent = new String[]{
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventsHome%2Fmajor_business.png?alt=media&token=b2c3f891-9789-4543-b102-578533a3592d",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventsHome%2Fmajor_directorscut.png?alt=media&token=581591dc-7298-48c8-b2b7-93a99f01caca",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventsHome%2Fmajor_codemania.png?alt=media&token=2d682a23-04f1-4592-a39e-6943a5d6ef64",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventsHome%2Fnoground.png?alt=media&token=e95c7d6e-1770-4baa-b6ec-773f3c566559",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventsHome%2Fmajor_robowar2.png?alt=media&token=e7b3b46a-536f-424a-ae0e-44c31e0a3640",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventsHome%2Fmajor_dota.jpg?alt=media&token=e91adf09-7a60-4f3b-bb9c-364bc3d83ad6"
    };

    public static final String[] smallEventImage = new String[]{
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Fmachine.png?alt=media&token=72e0b03a-885d-43da-8965-67f57cedb18f",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Fcode.png?alt=media&token=bc2d1cb4-e00e-41dc-8909-01d11a80d9c8",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Fcircuit.png?alt=media&token=29d982fe-205f-4b3f-8613-9a92ba154baa",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Fsiliconvalley.png?alt=media&token=8255a4ef-82b8-47d7-94a8-f1911d6d50d5",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Farthsastra.png?alt=media&token=4b3289e2-97d8-4d50-829a-0b08d3cc02c6",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Fakiriti.png?alt=media&token=ec3a8afe-e71f-4d6c-a770-1d54d3a29306",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Fduexmachina.png?alt=media&token=72892438-a216-4fb8-b2cd-efb32ceffe07",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Fprodus.png?alt=media&token=fc1ae821-af94-4ac4-a321-14b1ae17a6a8",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Fparpanalia.png?alt=media&token=01a258f5-9703-4806-aa02-b10f607423eb",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Fneodhristi.png?alt=media&token=c9411971-6b08-4efb-969c-d15387bf7cb1",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Favtaran.png?alt=media&token=113b08d8-2860-413f-9189-b000b19bca34",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Farmageddor.png?alt=media&token=351a95c8-d1e2-4b3d-bf0b-658633c55590",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Fpryas.png?alt=media&token=8e1c533c-9760-42f2-95c4-7f2a83b21240",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Fnogroundzone.png?alt=media&token=71ad6670-520d-4922-916f-c0b061a4b71b",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Fncet.png?alt=media&token=2135ab84-39ce-4598-86bc-e496a496f93e",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Flivecs.png?alt=media&token=882a27c1-5351-414b-8f3d-7d4108c1ef2d",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventSquareNew%2Fexposition.png?alt=media&token=1aac89b8-92f5-41be-95f4-a69a89c0d334"
    };

    public static final String[] largeEventImage = new String[]{
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2FRise%20of%20Machines.jpg?alt=media&token=af51adb0-e4a3-4b5a-943b-5702cf65da31",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2FVishwa%20CodeGenesis.jpg?alt=media&token=d56ac674-b138-4a40-8680-cb89073e52bd",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2FCircuit%20House.jpg?alt=media&token=96c6066d-f180-47b6-a76e-9fe15c2a4ce0",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2FSilicon%20valley.jpg?alt=media&token=67e22914-3fa7-4905-8da6-a153b7d41392",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2FArthashastra.jpg?alt=media&token=f853cee7-a079-469b-8b39-e0e4ef096259",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2FAakriti.jpg?alt=media&token=0714c022-c633-4d94-a2fc-558b3dc60d14",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2FDeus%20X%20Machina.jpg?alt=media&token=4ac15527-ea9c-4b46-a32a-94fb3b031691",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2Fprodus.jpg?alt=media&token=21d07b2f-6974-4f96-9008-a543a5916007",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2Fparapharnalia.jpg?alt=media&token=9b5ca84e-2b5e-4466-bc06-8de95c001320",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2FNeo%20Drishti.jpg?alt=media&token=a3aab957-3f4f-48de-a6d7-b9ee424c446b",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2Favartan.jpg?alt=media&token=454e6c90-8739-43a9-8fc8-df93b0adf02a",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2FArmageddon1.jpg?alt=media&token=06c1de3b-c030-4ba3-b0bb-86c56063059c",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2Fprayas.jpg?alt=media&token=6a0a68e9-e5b1-4db6-9434-16d5adc30a68",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2FNo%20Ground%20Zone.jpg?alt=media&token=7c27c8af-191c-4f10-8c38-82003317a3e9",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2FNSCET.jpg?alt=media&token=734d3106-e787-46bb-9ffd-1132a08ee0ef",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2FLive%20CS.jpg?alt=media&token=91af9b6f-2cbb-4f6c-8426-0318b7abd430",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages2%3A1%2Fexposition.jpg?alt=media&token=7a8300d3-abb9-4f57-9800-475feb7a0111",
    };

    public static final String eventNames[] = new String[]{
            "Rise of Machines",
            "Vishwa CodeGenesis",
            "Circuit House",
            "Silicon Valley",
            "ArthaShastra",
            "Aakriti",
            "Deus-X-Machina",
            "Produs",
            "Paraphernalia",
            "NeoDrishti",
            "Avartan",
            "Armageddon",
            "Prayas",
            "No Ground Zone",
            "NSCET",
            "LiveCS",
            "Exposicion"
    };

    public static final String[][] EventList = new String[][]{
            {"Autoquiz","Accelodrome","Junkyard Wars","Samveg","Prakshepan","Enigma","Ansys"},
            {"App Droid","Algorithma","Codemania","Code-O-Soccer","Sudo Code","Labyrinth","Web Weaver","Tech-Know"},
            {"High Voltage Concepts (HVC)","Elixir of Electricity","Pro-Lo-Co","Mat Sim","Nexus","Electro-Q","Who Am I"},
            {"Tukvilla","Jigyasa","Codesense","Analog Hunter","Digizone","Netkraft","Embetrix"},
            {"ABC","Neetishastra","Let's Start Up","Corporate Roadies","Bizzathlon","Wolf of Dalal Street", "Teenpreneur"},
            {"Acumen","Sanrachna","Archmadeease","Exempler","Pipe-o-Mania","Metropolis"},
            {"360 Mania","Tachyon","Battleship","Kurukshetra","MAC FIFA","Shapeshifter"},
            {"Industrial Tycoon", "Utpreaks","Artifact", "DronaGyan", "M&I Quiz"},
            {"The Great Ojass Race", "TechArt", "Mad Ad", "Lens View", "Director's Cut"},
            {"Codiyapa","Game of Troves","Scratch Easy","SimplySql","Tame the pyhton"},
            {"Spectra","Agnikund","Metal Trivia","Innovision","K.O."},
            {"FIFA","Counter Strike- Global Offensive","NFS Most Wanted","Angry Birds","DOTA"},
            {"Jagriti","Samvedna","Pratibimb"},
            {"Touch Down the plane","MICAV"},
            {"NSCET"},
            {"LiveCS"},
            {"Exposicion"}
    };

    public static final String[][] branchHeadName = new String[][]{
            {"Ikshwaku Kumar Dwivedi", "Amit Kumar", "Anand Kashyap"},
            {"Shikhar Kunal","Ankita Bohra", "Abhishek Keshri"},
            {"Krishna Gopal Singh", "Arnav Sarkar", "Diksha Agarwal"},
            {"Niraj Kumar", "Sacchi Prakash", "Shubham Anand"},
            {"Sujeet Gupta", "Shalini Singh"},
            {"Nikhil Kumar", "Nidhi Nivedita", "Vishal Singh"},
            {"Kaushik Komanduri", "Sammeta Saisaran", "Sushil Rajwar"},
            {"Vivek Banerjee", "Ajit Kumar Gupta", "Akanksha Sinha"},
            {"Poras Thavnani"},
            {"Hrishikesh Kumar", "Kanika Parnami", "Abhishek Sharma"},
            {"Kumar Adarsh", "Richa Ojha", "BH.V.Vijay"},
            {"Jibak Roy", "Abhishek Roul"},
            {"Khusboo Rani", "Manish Kumar", "Ujjwal Kumar Yadav"},
            {"Pankaj Kumar"},
            {"Kumar Ankur"},
            {"Rahul Meena"},
            {"Gajendra Kumar Gupta"}
    };

    public static final String[][] branchHeadNum = new String[][]{
            {"8051377895", "8507909903", "7070469511"},
            {"9470979069", "7209227678", "7903580340"},
            {"9471126529", "7070654097", "8092348666"},
            {"7070613942", "7631184347", "8789522609"},
            {"7828077280", "7004871347"},
            {"7783825879", "9973949841", "8406080962"},
            {"8008458784","9471105567", "9905183679"},
            {"7050544344", "9304018524", "9304359578"},
            {"8797361542"},
            {"9504047586", "9651010322", "9711487046"},
            {"9931167630", "8340674404", "9777988058"},
            {"9470177612", "7992455725"},
            {"8757080513", "8541833888", "9771935189"},
            {"9304022913"},
            {"8406028040"},
            {"9530476929"},
            {"7209359790"}
    };

}
