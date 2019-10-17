package com.irfan.billionaires2019;

import android.os.Parcel;
import android.os.Parcelable;

public class Billionaires implements Parcelable {
    private String nama, uang, desc, rank, foto;

    protected Billionaires(Parcel in) {
        nama = in.readString();
        uang = in.readString();
        desc = in.readString();
        rank = in.readString();
        foto = in.readString();
    }

    public Billionaires() {

    }



    public static final Creator<Billionaires> CREATOR = new Creator<Billionaires>() {
        @Override
        public Billionaires createFromParcel(Parcel in) {
            return new Billionaires(in);
        }

        @Override
        public Billionaires[] newArray(int size) {
            return new Billionaires[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUang() {
        return uang;
    }

    public void setUang(String uang) {
        this.uang = uang;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(uang);
        parcel.writeString(desc);
        parcel.writeString(rank);
        parcel.writeString(foto);
    }
}
