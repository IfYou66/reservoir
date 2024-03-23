package com.szsk.archives.test;


import com.alibaba.fastjson.JSONObject;

import java.sql.SQLOutput;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class JsonToString {


    public static void main(String[] args) {
        String strJson =
                "\t\tdistribution:'配送方式',\n" +
                        "    determine: 'Pasti',\n" +
                        "    cancel: 'Batal',\n" +
                        "    submittedSuccessfully: 'Berjaya hantar',\n" +
                        "    submissionFailed: 'Gagal hantar',\n" +
                        "    modifiedSuccessfully: 'Berjaya ubah suai',\n" +
                        "    modifiedFail: 'Gagal ubah suai',\n" +
                        "    addedSuccessfully: 'Berjaya tambah',\n" +
                        "    addedFailed: 'Gagal tambah',\n" +
                        "    confirm: 'Pasti',\n" +
                        "    submit: 'Hantar',\n" +
                        "    takePictures: 'Ambil gambar',\n" +
                        "    selectFromAlbum: 'Pilih dari galeri',\n" +
                        "    uploadUpTo5Pictures: 'Muat naik sehingga 5 gambar',\n" +
                        "    pleaseFillOut: 'Sila isikan',\n" +
                        "    filledIn: 'Sudah isikan',\n" +
                        "    pleaseChoose: 'Sila pilih',\n" +
                        "    discountReminder: 'Sila masukkan kadar diskaun',\n" +
                        "    save: 'Simpan',\n" +
                        "    Yes: 'Ya',\n" +
                        "    no: 'Tidak',\n" +
                        "    share: 'Bahagian',\n" +
                        "    monthlySales: 'Bulanan Jualan',\n" +
                        "    praise: 'Ulusan Baik',\n" +
                        "    limitedSupplyPerOrder: 'Bekalan terhad untuk setiap pesanan',\n" +
                        "    deletedSuccessfully: 'Berjaya padamkan',\n" +
                        "    deletedFail: 'Gagal padamkan',\n" +
                        "    prompt: 'Peringatan',\n" +
                        "    merchantReply: 'Balasan peniaga',\n" +
                        "    send: 'Hantar',\n" +
                        "    all: 'Semua',\n" +
                        "    startingTime: 'Masa bermula',\n" +
                        "    endTime: 'Masa tamat',\n" +
                        "    orderTime: 'Masa Pesanan',\n" +
                        "\tstoreTime:'Masa ketibaan',\n" +
                        "    missedOrders: 'Pesanan Terlepas',\n" +
                        "\t\tChangeorders: 'Modify',\n" +
                        "    pendingOrder: 'Pesanan belum selesai',\n" +
                        "    orderReceived: 'Pesanan diterima',\n" +
                        "    paid: 'Sudah Dibayar',\n" +
                        "    completed: 'Siap',\n" +
                        "    comment: 'Komen',\n" +
                        "    refunded: 'Dikembalikan',\n" +
                        "    cancelled: 'Dibatalkan',\n" +
                        "    evaluated: 'Disemak',\n" +
                        "    confirmed: 'Disahkan',\n" +
                        "    discounted: 'Diskaun',\n" +
                        "    total: 'Sub total',\n" +
                        "    orderInformation: 'Butiran pesanan',\n" +
                        "    orderNumber: 'Nombor Pesanan',\n" +
                        "    remarks: 'Permintaan Khas',\n" +
                        "    contactInformation: 'Nombor Telefon',\n" +
                        "    numberOfMeals: 'Bilangan Orang',\n" +
                        "    paymentMethod: 'Keadah Pembayaran',\n" +
                        "    orders: 'Terima pesanan',\n" +
                        "    unpaid: 'Tidak dibayar',\n" +
                        "    printReceipt: 'Cetak resit',\n" +
                        "    orderNumber: 'Nombor pesanan',\n" +
                        "    pleaseSelectDishType: 'Sila pilih jenis hidangan',\n" +
                        "    pleaseSelectAtLeastOneCategory: 'Sila pilih sekurang-kurangnya satu kategori',\n" +
                        "    name: 'Nama',\n" +
                        "    pleaseTypeInYourName: 'Sila isikan nama anda',\n" +
                        "    saveSettings: 'Simpan',\n" +
                        "    avatar: 'Gambar Profil',\n" +
                        "    gender: 'Jantina',\n" +
                        "    pleaseEnter: 'Sila isikan',\n" +
                        "    delete: 'Padam',\n" +
                        "    uploadUpTo20Pctures: 'Muat naik sehingga 20 gambar',\n" +
                        "    pleaseUploadPicture: 'Sila muat naik gambar',\n" +
                        "    bankCardReminder: 'Sila isikan nombor kad bank anda dengan betul】 jadi itu pendapatan anda akan masuk dalam akaun anda',\n" +
                        "    todayOrder: 'Pesanan',\n" +
                        "    systemNotification: 'Buletin',\n" +
                        "    dishesDescription: 'Hidangan Penerangan',\n" +
                        "    packageDescription: 'Penerangan',\n" +
                        "    useTimePeriod: 'Tempoh Masa',\n" +
                        "    rulesOfUse: 'Peraturan'";


        String[] strings = strJson.split(",");
        String str = "商家端-公共       public/";
        for(String string : strings) {
            System.out.println(str + string.split(":")[0].trim());
        }
        System.out.println("\n\n");
        for(String string : strings) {

            System.out.println(string.split(":")[1].substring(1,string.split(":")[1].length() - 1));
        }


    }

    public static void strToMap(String string) {
        String[] strList = string.split("},");
        Map<String, Map<String, Object>> map = new HashMap<>();


        for(String str : strList) {
            Map<String, Object> miniMap = new HashMap<>();
            String[] temp = str.split("{")[1].split(",");
            for(String nei : temp) {
                if(nei.equals("")) {
                    miniMap.put(nei.split(":")[0].trim(), nei.split(":")[1]);
                }
            }
            map.put(str.split("{")[0],miniMap);
        }
        System.out.println(map);
    }

}




