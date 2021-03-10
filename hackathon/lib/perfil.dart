import 'package:flutter/material.dart';

class PerfilPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Tela de perfil'),
        bottomOpacity: 0.0,
        elevation: 0.0,
      ),
      body: Container(
        margin: EdgeInsets.only(top: 10),
        padding: EdgeInsets.all(12),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: <Widget>[
                Container(
                  height: 100,
                  width: 100,
                  color: Color(0xFF006400),
                  margin: EdgeInsets.only(bottom: 20),
                ),
                Container(
                  height: 40,
                  width: 120,
                  decoration: BoxDecoration(
                    border: Border.all(
                      color: Color(0xFF006400),
                    ),
                  ),
                  child: Center(
                      child: Text(
                    'Editar',
                    style: TextStyle(
                      fontSize: 16,
                      fontWeight: FontWeight.bold,
                      color: Color(0xFF006400),
                    ),
                  )),
                )
              ],
            ),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                Text(
                  'Nome:',
                  style: TextStyle(
                      color: Color(0xFF006400),
                      fontSize: 20,
                      fontWeight: FontWeight.bold),
                ),
                Text(
                  'Francisco Pereira',
                  style: TextStyle(fontSize: 20),
                ),
                SizedBox(height: 25),
                SizedBox(
                  height: 25,
                ),
                Text(
                  'Telefone:',
                  style: TextStyle(color: Color(0xFF006400), fontSize: 20),
                ),
                Text(
                  '(88) 9898-9898',
                  style: TextStyle(fontSize: 20),
                ),
                SizedBox(
                  height: 25,
                ),
                Text(
                  'Email:',
                  style: TextStyle(color: Color(0xFF006400), fontSize: 20),
                ),
                Text(
                  'francisco@gmail.com',
                  style: TextStyle(fontSize: 20),
                ),
                SizedBox(
                  height: 25,
                ),
                Text(
                  'Endereço:',
                  style: TextStyle(color: Color(0xFF006400), fontSize: 20),
                ),
                Text(
                  'Rua Dr. Jose Alaumeida, n° 100',
                  style: TextStyle(fontSize: 16),
                ),
              ],
            )
          ],
        ),
      ),
    );
  }
}
