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
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Friseofmachines.jpg?alt=media&token=08c2dc21-68c8-43e2-b7f8-3990ea5d9d12",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Fvishwacodegen.jpg?alt=media&token=2420396e-592c-4c86-beab-9675b7ce5277",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2FcircuitHouse.jpg?alt=media&token=2d0a0205-f516-40e6-95c0-20cdc3469b6d",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Fsilicon.jpg?alt=media&token=b0f8992c-fd5e-4e41-9f97-ccfb4e93fd16",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Farthsashtra.jpg?alt=media&token=e392b1ad-a75e-4fe1-929e-07040f823060",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Fakriti.jpg?alt=media&token=11df2810-6646-435a-b9ff-0abb612684c6",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Fdeusxmachina.jpg?alt=media&token=b70e7814-f03e-47a7-bd6b-6bb964a69324",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Fprodus.jpg?alt=media&token=c0f25469-dcf3-4175-b80c-c34a7c77c596",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Fpara.jpg?alt=media&token=6f75121e-ba8c-4989-8e2e-b67cc2911ea3",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Fneodrishti.jpg?alt=media&token=d238074b-365e-45d1-9e1f-5f4b3e19181f",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Favartan.jpg?alt=media&token=3c260e7c-5edc-4337-b87d-dca3211d0453",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Farmageddon.jpg?alt=media&token=b1d527ee-2c7a-4e72-b70d-05b96ac00139",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2FPrayas.jpg?alt=media&token=727fa9e8-f848-4420-8d65-0fd4ed6744b6",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Fnogz.jpg?alt=media&token=232221bc-48ae-4a0d-8d7d-5cf5f72e9076",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Fnscet.jpg?alt=media&token=4dea8d55-cc5c-45e5-8581-1124b932a7f3",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2FliveCS.jpg?alt=media&token=34fa6a52-95fa-4e88-b95f-7aded4188332",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Fexcosicion.jpg?alt=media&token=8669b3c8-df88-42a4-be0b-0ac4988c1417",
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
