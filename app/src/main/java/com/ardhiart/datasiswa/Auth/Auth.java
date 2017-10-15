package com.ardhiart.datasiswa.Auth;

import android.content.Context;
import android.content.SharedPreferences;

import com.ardhiart.datasiswa.API.Model.Siswa;

/**
 * Created by Hinata on 10/14/2017.
 */
public class Auth {
    private static final String LOGIN_PREFERENCE_KEY = "preferenceLogin";

    private static final String KEY_NAMA = "name";
    private static final String KEY_ALAMAT = "alamat";
    private static final String KEY_TGL_LAHIR = "tanggal_lahir";
    private static final String KEY_TEMPAT_LAHIR = "tempat_lahir";
    private static final String KEY_DESC = "desc";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ID = "id";
    private static final String KEY_NO = "no";
    private static final String KEY_LOGIN = "login";

    public static void saveLoginInformation(Siswa siswa, Context context){
        SharedPreferences loginInfo = context.getSharedPreferences(LOGIN_PREFERENCE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = loginInfo.edit();
        editor.clear();
        editor.putString(KEY_NAMA, siswa.getNama());
        editor.putString(KEY_ALAMAT, siswa.getAlamat());
        editor.putString(KEY_TGL_LAHIR, siswa.getTanggal_lahir());
        editor.putString(KEY_TEMPAT_LAHIR, siswa.getTempat_lahir());
        editor.putString(KEY_DESC, siswa.getDesc());
        editor.putString(KEY_USERNAME, siswa.getUsername());
        editor.putString(KEY_EMAIL, siswa.getEmail());
        editor.putString(KEY_ID, siswa.getId());
        editor.putString(KEY_NO, siswa.getNo());
        editor.putBoolean(KEY_LOGIN, true);
        editor.apply();
    }

    public static void logOut(Context context){
        SharedPreferences loginInfo = context.getSharedPreferences(LOGIN_PREFERENCE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = loginInfo.edit();
        editor.clear();
    }

    public static Siswa getLoginInformation(Context context){
        SharedPreferences loginInfo = context.getSharedPreferences(LOGIN_PREFERENCE_KEY, Context.MODE_PRIVATE);
        Siswa siswa = new Siswa();
        siswa.setNama(loginInfo.getString(KEY_NAMA, ""));
        siswa.setAlamat(loginInfo.getString(KEY_ALAMAT, ""));
        siswa.setTanggal_lahir(loginInfo.getString(KEY_TGL_LAHIR, ""));
        siswa.setTempat_lahir(loginInfo.getString(KEY_TEMPAT_LAHIR, ""));
        siswa.setDesc(loginInfo.getString(KEY_DESC, ""));
        siswa.setUsername(loginInfo.getString(KEY_USERNAME, ""));
        siswa.setEmail(loginInfo.getString(KEY_EMAIL, ""));
        siswa.setId(loginInfo.getString(KEY_ID, ""));
        siswa.setNo(loginInfo.getString(KEY_NO, ""));
        return siswa;
    }

    public static boolean isLogin(Context context){
        SharedPreferences loginInfo = context.getSharedPreferences(LOGIN_PREFERENCE_KEY, Context.MODE_PRIVATE);
        return loginInfo.getBoolean(KEY_LOGIN, login);
    }

    public static boolean login = false;

}
