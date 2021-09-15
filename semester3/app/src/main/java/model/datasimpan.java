package model;

import android.os.Parcel;
import android.os.Parcelable;

public class datasimpan implements Parcelable {
    private String nama,umur,alamat,gambar;

    public datasimpan(String nama,String umur, String alamat, String gambar) {
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
        this.gambar = gambar;

    }
    public datasimpan() {
        this.nama = "";
        this.umur = "";
        this.alamat = "";
        this.gambar="";

    }

    protected datasimpan(Parcel in) {
        nama = in.readString();
        umur = in.readString();
        alamat = in.readString();
        gambar = in.readString();

    }

    public static final Creator<model.datasimpan> CREATOR = new Creator<model.datasimpan>() {
        @Override
        public model.datasimpan createFromParcel(Parcel in) {
            return new model.datasimpan(in);
        }

        @Override
        public model.datasimpan[] newArray(int size) {
            return new model.datasimpan[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(umur);
        dest.writeString(alamat);
        dest.writeString(gambar);

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public static Creator<model.datasimpan> getCREATOR() {
        return CREATOR;
    }

}
