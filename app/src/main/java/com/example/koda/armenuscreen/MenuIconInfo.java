package com.example.koda.armenuscreen;

/**
 * Created by K.Oda on 2017/09/09.
 */

public class MenuIconInfo {

    //region icon名
    private String[] iconName = {
            "ARCamera",
            "Comment",

    };
    //endregion

    //region icon画像
    private Integer[] iconImage ={
            R.drawable.icon_ar_camera,
            R.drawable.icon_ar_camera,

    };
    //endregion

    //region 画面遷移先クラス
    private  Object[] nextActivityClass ={
           TestActivity.class,//テスト画面（Camera画面と入れ替える）
            CommentActivity.class,

    };
    //endregion

    //region コンストラクター
    public MenuIconInfo(){

    }
    //endregion


    //region メソッド
    public int getCountIcon() {
        return iconImage.length;
    }

    //アイコン画像取得
    public Object getItem(int position) {
        return iconImage[position];
    }

    //アイコン名取得
    public String getIconName(int position){
        return iconName[position];
    }

    //遷移先を取得
    public Object getNextActivity(int position){
        return nextActivityClass[position];
    }

    //endregion


}
