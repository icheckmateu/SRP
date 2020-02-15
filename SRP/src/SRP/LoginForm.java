package SRP;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 *
 *负责显示界面，因此只包含与界面有关的方法和事件处理方法
 *
 */
public class LoginForm extends JFrame  {

    private UserDAO dao;
    private JButton btnLogin=null;
    private JButton btnClear=null;
    private JTextField txtId=null;
    private JTextField txtPwd=null;
    private JLabel lblId=null;
    private JLabel lblPwd=null;
    public LoginForm() {
        setVisible(true);
    }
    public void init()//初始化控件
    {
        btnLogin=new JButton("登录");
        btnClear=new JButton("清空");
        lblId=new JLabel("账号：");
        lblPwd=new JLabel("密码：");
        txtId=new JTextField();
        txtPwd=new JTextField();

        lblId.setBounds(80,50,40,20);
        lblPwd.setBounds(80,80,40,20);
        txtId.setBounds(130,50,100,20);
        txtPwd.setBounds(130,80,100,20);
        btnLogin.setBounds(80,110,70,20);
        btnClear.setBounds(160,110,70,20);
        //添加事件
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Validate();
            }
        });
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtId.setText("");
                txtPwd.setText("");

            }
        });
    }
    public void display()//面板添加控件
    {

        Container container=this.getContentPane();
        setTitle("登录");
        setLayout(null);//绝对布局
        setSize(300,250);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭窗口默认方式
        setBackground(Color.yellow);

        container.add(btnClear);
        container.add(btnLogin);
        container.add(lblId);
        container.add(lblPwd);
        container.add(txtId);
        container.add(txtPwd);

    }

    public void Validate()//验证用户   此处提醒Java小白（我自己）JFrame有个validate（）函数，如果不自己重新正确命名，就会有意想不到的效果（嘿嘿嘿）。
    {

        dao=new UserDAO();
        String userId=txtId.getText().trim();
        String password=txtPwd.getText().trim();
        if(dao.findUser(userId, password)==true)
        {
            JOptionPane.showMessageDialog(null, "登录成功");
        }

        else
        {
            JOptionPane.showMessageDialog(null, "登录失败");
        }

    }

}