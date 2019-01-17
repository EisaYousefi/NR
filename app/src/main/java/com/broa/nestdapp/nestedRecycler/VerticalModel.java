package com.broa.nestdapp.nestedRecycler;

import com.broa.nestdapp.R;

import java.util.ArrayList;
import java.util.List;

public class VerticalModel {

    private int img;
    private String title;
    private List<HorezintalModel> horezintalModelList;

    public VerticalModel( String title,int img) {
        this.img = img;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List <HorezintalModel> getHorezintalModelList() {
        return horezintalModelList;
    }

    public void setHorezintalModelList(List <HorezintalModel> horezintalModelList) {
        this.horezintalModelList = horezintalModelList;
    }

    public  static List<VerticalModel> getAll()
    {
        List<VerticalModel> verticalModelList = new ArrayList<>();
        String[] arrytiltle ={"Mohammad","Mosa","Asad","Salam","Broa","Heaman","Ali","Mohammad","Ramsin"};
        int[] picarray ={R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,
                R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10,R.drawable.p11};
        for (int i = 0; i <arrytiltle.length ; i++) {
            List<HorezintalModel> hmodelList = new ArrayList <>();
            HorezintalModel horezintalModel = new HorezintalModel(arrytiltle[i]);
            VerticalModel verticalModel = new VerticalModel(arrytiltle[i],picarray[i]);
            verticalModelList.add(verticalModel);
        }

        return verticalModelList;
    }
}
