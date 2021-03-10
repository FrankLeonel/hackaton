import 'package:flutter/material.dart';
import 'package:hackathon/home_com.dart';
import 'package:hackathon/mainpage.dart';

class LoginPage extends StatefulWidget {
  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final controller = TextEditingController();

  final controller2 = TextEditingController();

  String username = null;

  String password = null;
  bool loading = false;

  void authorization(context, String user, String pass) {
    if (user == 'adm' && pass == 'adm1') {
      Navigator.push(
          context, MaterialPageRoute(builder: (context) => MainPage()));
    } else if (user == 'adm' && pass == 'adm2') {
      Navigator.push(
          context, MaterialPageRoute(builder: (context) => Home_Comerciante()));
    }
  }

  void setNullController() {
    setState(() {
      controller.clear();
      controller2.clear();
      username = password = null;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        title: Text(
          'Login do usuário',
          style: TextStyle(color: Color(0xFF006400)),
        ),
      ),
      body: Container(
        padding: EdgeInsets.all(10),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: <Widget>[
              Text('Mercado Verde!',
                  style: TextStyle(
                      fontSize: 50,
                      color: Color(0xFF006400),
                      fontWeight: FontWeight.bold)),
              Container(
                padding: EdgeInsets.all(15),
                height: 400,
                width: double.infinity,
                decoration: BoxDecoration(
                    border: Border.all(color: Color(0xFF006400), width: 2),
                    borderRadius: BorderRadius.circular(8)),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    SizedBox(
                      height: 8,
                    ),
                    TextField(
                      style: TextStyle(color: Color(0xFF006400)),
                      obscureText: false,
                      decoration: InputDecoration(
                        enabledBorder: OutlineInputBorder(
                          borderRadius: BorderRadius.all(Radius.circular(10.0)),
                          borderSide: BorderSide(color: Color(0xFF006400)),
                        ),
                        focusedBorder: OutlineInputBorder(
                          borderRadius: BorderRadius.all(Radius.circular(10.0)),
                          borderSide: BorderSide(color: Color(0xFF006400)),
                        ),
                        border: OutlineInputBorder(
                            borderSide: BorderSide(color: Color(0xFF006400))),
                        labelText: 'Username',
                        labelStyle: TextStyle(color: Color(0xFF006400)),
                      ),
                      onChanged: (value) {
                        username = value;
                        print(controller.text);
                      },
                    ),
                    SizedBox(
                      height: 42,
                    ),
                    SizedBox(
                      height: 8,
                    ),
                    TextField(
                      obscureText: true,
                      style: TextStyle(color: Color(0xFF006400)),
                      decoration: InputDecoration(
                        enabledBorder: OutlineInputBorder(
                          borderRadius: BorderRadius.all(Radius.circular(10.0)),
                          borderSide: BorderSide(color: Color(0xFF006400)),
                        ),
                        focusedBorder: OutlineInputBorder(
                          borderRadius: BorderRadius.all(Radius.circular(10.0)),
                          borderSide: BorderSide(color: Color(0xFF006400)),
                        ),
                        labelText: 'Password',
                        border: OutlineInputBorder(),
                        labelStyle: TextStyle(
                          color: Color(0xFF006400),
                        ),
                      ),
                      onChanged: (value) {
                        password = value;
                        print(controller.text);
                      },
                    ),
                    loading == true
                        ? CircularProgressIndicator()
                        : SizedBox(
                            height: 50,
                          ),
                    InkWell(
                      onTap: () {
                        setState(() {
                          loading = true;
                        });
                        this.authorization(context, username, password);
                        setNullController();
                      },
                      child: Container(
                        decoration: BoxDecoration(
                            color: Colors.white,
                            border:
                                Border.all(color: Color(0xFF006400), width: 3)),
                        height: 55,
                        width: double.infinity,
                        padding: EdgeInsets.all(15),
                        child: Center(
                          child: Text(
                            'Entrar',
                            style: TextStyle(
                                fontWeight: FontWeight.bold,
                                fontSize: 20,
                                color: Color(0xFF006400)),
                          ),
                        ),
                      ),
                    ),
                    SizedBox(height: 15),
                    InkWell(
                      child: Text(
                        'Não tem conta? Cadastre-se!',
                        style: TextStyle(
                            color: Color(0xFF006400),
                            fontWeight: FontWeight.bold,
                            fontSize: 15),
                      ),
                    )
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
