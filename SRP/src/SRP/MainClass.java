package SRP;

public class MainClass {

    public MainClass() {
        LoginForm form=new LoginForm();
        form.initControls();
        form.showControls();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MainClass();//程序入口
    }

}