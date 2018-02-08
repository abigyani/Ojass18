package in.nitjsr.ojass.EventsFolding;

import android.view.View;

import java.util.ArrayList;

import in.nitjsr.ojass.R;

import static in.nitjsr.ojass.Utils.Constants.smallEventImage;
import static in.nitjsr.ojass.Utils.Constants.largeEventImage;

/**
 * Simple POJO model for example
 */
public class Item {

    private String price;
    private String pledgePrice;
    private String fromAddress;
    private String toAddress;
    private int requestsCount;
    private String date;
    private String time;
    private String headEventName, headEventTag;
    private String sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10,MainiEvent;
    private String image1,image2;

    private View.OnClickListener requestBtnClickListener1,requestBtnClickListener2,requestBtnClickListener3,requestBtnClickListener4,
            requestBtnClickListener5,requestBtnClickListener6,requestBtnClickListener7,
            requestBtnClickListener8,requestBtnClickListener9,requestBtnClickListener10,requestBtnClickListener11;

    public Item() {
    }

    public Item(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String headEventName,
                String headEventTag, String main, String main2) {
        this.sub1 = s1;
        this.sub2 = s2;
        this.sub3 = s3;
        this.sub4 = s4;
        this.sub5 = s5;
        this.sub6 = s6;
        this.sub7 = s7;
        this.sub8 = s8;
        this.sub9 = s9;
        this.sub10 = s10;
        this.headEventName = headEventName;
        this.headEventTag = headEventTag;
        this.image1=main;
        this.image2=main2;

    }

    public String getSub1() {
        return sub1;
    }

    public void setSub1(String sub1) {
        this.sub1 = sub1;
    }

    public String getSub2() {
        return sub2;
    }

    public void setSub2(String sub2) {
        this.sub2 = sub2;
    }

    public String getSub3() {
        return sub3;
    }

    public void setSub3(String sub3) {
        this.sub3 = sub3;
    }

    public String getSub4() {
        return sub4;
    }

    public void setSub4(String sub4) {
        this.sub4 = sub4;
    }

    public String getSub5() {
        return sub5;
    }

    public void setSub5(String sub5) {
        this.sub5 = sub5;
    }

    public String getSub6() {
        return sub6;
    }

    public void setSub6(String sub6) {
        this.sub6 = sub6;
    }

    public String getSub7() {
        return sub7;
    }

    public void setSub7(String sub7) {
        this.sub7 = sub7;
    }

    public String getSub10() {
        return sub10;
    }

    public void setSub10(String sub10) {
        this.sub10 = sub10;
    }

    public String getSub9() {
        return sub9;
    }

    public void setSub9(String sub9) {
        this.sub9 = sub9;
    }

    public String getSub8() {
        return sub8;
    }

    public void setSub8(String sub8) {
        this.sub8 = sub8;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPledgePrice() {
        return pledgePrice;
    }

    public void setPledgePrice(String pledgePrice) {
        this.pledgePrice = pledgePrice;
    }

    public String getMainiEvent() {
        return MainiEvent;
    }

    public void setMainiEvent(String mainiEvent) {
        MainiEvent = mainiEvent;
    }

    public String getImage() {
        return image1;
    }

    public void setImage(String Image) {
        image1 = Image;
    }

    public String getImage1() {
        return image2;
    }

    public void setImage1(String Image) {
        image2 = Image;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public int getRequestsCount() {
        return requestsCount;
    }

    public void setRequestsCount(int requestsCount) {
        this.requestsCount = requestsCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHeadEventName() {
        return headEventName;
    }

    public void setHeadEventName(String headEventName) {
        this.headEventName = headEventName;
    }

    public String getHeadEventTag() {
        return headEventTag;
    }

    public void setHeadEventTag(String headEventTag) {
        this.headEventTag = headEventTag;
    }

    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener1;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener1 = requestBtnClickListener;
    }

    public View.OnClickListener getRequestBtnClickListener2() {
        return requestBtnClickListener2;
    }

    public void setRequestBtnClickListener2(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener2 = requestBtnClickListener;
    }

    public View.OnClickListener getRequestBtnClickListener3() {
        return requestBtnClickListener3;
    }

    public void setRequestBtnClickListener3(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener3 = requestBtnClickListener;
    }

    public View.OnClickListener getRequestBtnClickListener4() {
        return requestBtnClickListener4;
    }

    public void setRequestBtnClickListener4(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener4 = requestBtnClickListener;
    }

    public View.OnClickListener getRequestBtnClickListener5() {
        return requestBtnClickListener5;
    }

    public void setRequestBtnClickListener5(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener5 = requestBtnClickListener;
    }

    public View.OnClickListener getRequestBtnClickListener6() {
        return requestBtnClickListener6;
    }

    public void setRequestBtnClickListener6(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener6 = requestBtnClickListener;
    }

    public View.OnClickListener getRequestBtnClickListener7() {
        return requestBtnClickListener7;
    }

    public void setRequestBtnClickListener7(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener7 = requestBtnClickListener;
    }

    public View.OnClickListener getRequestBtnClickListener8() {
        return requestBtnClickListener8;
    }

    public void setRequestBtnClickListener8(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener8 = requestBtnClickListener;
    }

    public View.OnClickListener getRequestBtnClickListener9() {
        return requestBtnClickListener9;
    }

    public void setRequestBtnClickListener9(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener9 = requestBtnClickListener;
    }

    public View.OnClickListener getRequestBtnClickListener10() {
        return requestBtnClickListener10;
    }

    public void setRequestBtnClickListener10(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener10 = requestBtnClickListener;
    }

    public View.OnClickListener getRequestBtnClickListener11() {return requestBtnClickListener11;
    }

    public void setRequestBtnClickListener11(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener11 = requestBtnClickListener;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (requestsCount != item.requestsCount) return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        if (pledgePrice != null ? !pledgePrice.equals(item.pledgePrice) : item.pledgePrice != null)
            return false;
        if (fromAddress != null ? !fromAddress.equals(item.fromAddress) : item.fromAddress != null)
            return false;
        if (toAddress != null ? !toAddress.equals(item.toAddress) : item.toAddress != null)
            return false;
        if (date != null ? !date.equals(item.date) : item.date != null) return false;
        return !(time != null ? !time.equals(item.time) : item.time != null);

    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (pledgePrice != null ? pledgePrice.hashCode() : 0);
        result = 31 * result + (fromAddress != null ? fromAddress.hashCode() : 0);
        result = 31 * result + (toAddress != null ? toAddress.hashCode() : 0);
        result = 31 * result + requestsCount;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    /**
     * @return List of elements prepared for tests
     */
    public static ArrayList<Item> getTestingList() {
        ArrayList<Item> items = new ArrayList<>();
        String Array1[]={"ArthaShastra","Circuit House","Vishwa CodeGenesis","No Ground Zone","Paraphernalia","Produs","Silicon Valley","Rise of Machines"
                ,"NSCET","NeoDrishti","Exposicion","Deus-X-Machina","Avartan","Armageddon","Aakriti","Prayas","LiveCS"};

        String[] Array2={smallEventImage[0],smallEventImage[1],smallEventImage[2],smallEventImage[3],smallEventImage[4],smallEventImage[5],
                smallEventImage[6],smallEventImage[7],smallEventImage[8],smallEventImage[9],smallEventImage[10],smallEventImage[11],smallEventImage[12],
                smallEventImage[13],smallEventImage[14],smallEventImage[15],smallEventImage[16]};

        String[] Array3={largeEventImage[0],largeEventImage[1],largeEventImage[2],largeEventImage[3],largeEventImage[4],largeEventImage[5],
                largeEventImage[6],largeEventImage[7],largeEventImage[8],largeEventImage[9],largeEventImage[10],largeEventImage[11],largeEventImage[12],
                largeEventImage[13],largeEventImage[14],largeEventImage[15],largeEventImage[16]};

/*
        items.add(new Item("ABC","Neetishastra","Let's Start Up","Corporate Roadies","Bizzathlon","Wolf of Dalal Street",
                "Selfie Ad","Teenpreneur",null,null,Array1[0], "Dream Dare Achieve",Array2[0],Array3[0]));
        items.add(new Item("High Voltage Concepts (HVC)","Elixir of Electricity","Pro-Lo-Co","Mat Sim","Nexus","Electro-Q","Who Am I",null,null,null,Array1[1], "Dream Dare Achieve",Array2[1],Array3[1]));
        items.add(new Item("App Droid","Algorithma","Codemania","Code-O-Soccer","Sudo Code","Labyrinth","Web Weaver","Tech Know",null,null,Array1[2], "Dream Dare Achieve",Array2[2],Array3[2]));
        items.add(new Item("Touch Down the plane","MICAV",null, null, null, null,null,null,null,null,Array1[3], "Dream Dare Achieve",Array2[3],Array3[3]));
        items.add(new Item("The Great Ojass Race","SCI FI", "Mad Ad", "Lens View", "Director's Cut", null, null, null,null,null,Array1[4], "Dream Dare Achieve",Array2[4],Array3[4]));
        items.add(new Item("Industrial Tycoon", "Utpreaks","Artifact", "DronaGyan", "M&I Quiz", null, null, null,null,null,Array1[5], "Dream Dare Achieve",Array2[5],Array3[5]));
        items.add(new Item("Tukvilla","Jigyasa","Codesense","Analog Hunter","Digizone","Netkraft","Embetrix",null,null,null,Array1[6], "Dream Dare Achieve",Array2[6],Array3[6]));
        items.add(new Item("Autoquiz","Accelodrome","Junkyard Wars","Samveg","Prakshepan","Enigma","Ansys",null,null,null,Array1[7], "Dream Dare Achieve",Array2[7],Array3[7]));
        items.add(new Item("NSCET",null,null,null,null,null,null,null,null,null,Array1[8], "Dream Dare Achieve",Array2[8],Array3[8]));
        items.add(new Item("Codiyapa","Game of Troves","Scratch Easy","SimplySql","Tame the pyhton",null,null,null,null,null,Array1[9], "Dream Dare Achieve",Array2[9],Array3[9]));
        items.add(new Item("Exposicion",null,null,null,null,null,null,null,null,null,Array1[10], "Dream Dare Achieve",Array2[10],Array3[10]));
        items.add(new Item("360 Mania","Tachyon","Battleship","Kurukshetra","MAC FIFA","Shapeshifter",null,null,null,null,Array1[11], "Dream Dare Achieve",Array2[11],Array3[11]));
        items.add(new Item("Spectra","Agnikund","Metal Trivia","Innovision","K.O.",null,null,null,null,null,Array1[12], "Dream Dare Achieve",Array2[12],Array3[12]));
        items.add(new Item("FIFA","Counter Strike- Global Offensive","NFS Most Wanted","Angry Birds","DOTA",null,null,null,null,null,Array1[13], "Dream Dare Achieve",Array2[13],Array3[13]));
        items.add(new Item("Acumen","Sanrachna","Archmadeease","Exempler","Pipe-o-Mania","Metropolis",null,null,null,null,Array1[14], "Dream Dare Achieve",Array2[14],Array3[14]));
        items.add(new Item("Jagriti","Samvedna","Pratibimb",null,null,null,null,null,null,null,Array1[15], "Dream Dare Achieve",Array2[15],Array3[15]));
        items.add(new Item("LiveCS",null,null,null,null,null,null,null,null,null,Array1[16], "Dream Dare Achieve",Array2[16],Array3[16]));

*/

        items.add(new Item("Autoquiz","Accelodrome","Junkyard Wars","Samveg","Prakshepan","Enigma","Ansys",null,null,null,Array1[7], "Dream Dare Achieve",Array2[7],Array3[7]));
        items.add(new Item("App Droid","Algorithma","Codemania","Code-O-Soccer","Sudo Code","Labyrinth","Web Weaver","Tech-Know",null,null,Array1[2], "Dream Dare Achieve",Array2[2],Array3[2]));
        items.add(new Item("High Voltage Concepts (HVC)","Elixir of Electricity","Pro-Lo-Co","Mat Sim","Nexus","Electro-Q","Who Am I",null,null,null,Array1[1], "Dream Dare Achieve",Array2[1],Array3[1]));
        items.add(new Item("Tukvilla","Jigyasa","Codesense","Analog Hunter","Digizone","Netkraft","Embetrix",null,null,null,Array1[6], "Dream Dare Achieve",Array2[6],Array3[6]));
        items.add(new Item("ABC","Neetishastra","Let's Start Up","Corporate Roadies","Bizzathlon","Wolf of Dalal Street",
                "Teenpreneur",null, null ,null,Array1[0], "Dream Dare Achieve",Array2[0],Array3[0]));
        items.add(new Item("Acumen","Sanrachna","Archmadeease","Exempler","Pipe-o-Mania","Metropolis",null,null,null,null,Array1[14], "Dream Dare Achieve",Array2[14],Array3[14]));
        items.add(new Item("360 Mania","Tachyon","Battleship","Kurukshetra","MAC FIFA","Shapeshifter",null,null,null,null,Array1[11], "Dream Dare Achieve",Array2[11],Array3[11]));
        items.add(new Item("Industrial Tycoon", "Utpreaks","Artifact", "DronaGyan", "M&I Quiz", null, null, null,null,null,Array1[5], "Dream Dare Achieve",Array2[5],Array3[5]));
        items.add(new Item("The Great Ojass Race", "TechArt", "Mad Ad", "Lens View", "Director's Cut", null, null,null,null, null,Array1[4], "Dream Dare Achieve",Array2[4],Array3[4]));
        items.add(new Item("Codiyapa","Game of Troves","Scratch Easy","SimplySql","Tame the pyhton",null,null,null,null,null,Array1[9], "Dream Dare Achieve",Array2[9],Array3[9]));
        items.add(new Item("Spectra","Agnikund","Metal Trivia","Innovision","K.O.",null,null,null,null,null,Array1[12], "Dream Dare Achieve",Array2[12],Array3[12]));
        items.add(new Item("FIFA","Counter Strike- Global Offensive","NFS Most Wanted","Angry Birds","DOTA",null,null,null,null,null,Array1[13], "Dream Dare Achieve",Array2[13],Array3[13]));
        items.add(new Item("Jagriti","Samvedna","Pratibimb",null,null,null,null,null,null,null,Array1[15], "Dream Dare Achieve",Array2[15],Array3[15]));
        items.add(new Item("Touch Down the plane","MICAV",null, null, null, null,null,null,null,null,Array1[3], "Dream Dare Achieve",Array2[3],Array3[3]));
        items.add(new Item("NSCET",null,null,null,null,null,null,null,null,null,Array1[8], "Dream Dare Achieve",Array2[8],Array3[8]));
        items.add(new Item("LiveCS",null,null,null,null,null,null,null,null,null,Array1[16], "Dream Dare Achieve",Array2[16],Array3[16]));
        items.add(new Item("Exposicion",null,null,null,null,null,null,null,null,null,Array1[10], "Dream Dare Achieve",Array2[10],Array3[10]));









        return items;

    }

}
