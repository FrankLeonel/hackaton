import 'package:flutter/material.dart';
import 'package:flutter/scheduler.dart';

class DetalhesPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Detalhes do Produto'),
        bottomOpacity: 0.0,
        elevation: 0.0,
      ),
      body: Container(
        margin: EdgeInsets.only(
          top: 25,
        ),
        padding: EdgeInsets.all(12),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            Container(
              padding: EdgeInsets.only(right: 8, left: 8),
              height: 40,
              width: 320,
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: <Widget>[
                  Text('Buscar'),
                  Icon(
                    Icons.search,
                    color: Color(0xFF006400),
                  ),
                ],
              ),
              decoration: BoxDecoration(
                  border: Border.all(color: Color(0xFF006400), width: 1),
                  borderRadius: BorderRadius.circular(8)),
            ),
            SizedBox(height: 30),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                Container(
                  height: 100,
                  width: 100,
                  color: Color(0xFF006400),
                  margin: EdgeInsets.only(bottom: 20),
                ),
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: <Widget>[
                    Text(
                      'Endereço:',
                      style: TextStyle(color: Color(0xFF006400), fontSize: 16),
                      textAlign: TextAlign.start,
                    ),
                    Text(
                      'Rua Dr. Jose Alaumeida, n° 100',
                      style: TextStyle(fontSize: 16),
                    )
                  ],
                )
              ],
            ),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                Text(
                  'Vendedor:',
                  style: TextStyle(
                      color: Color(0xFF006400),
                      fontSize: 20,
                      fontWeight: FontWeight.bold),
                ),
                Text(
                  'Francisco Pereira',
                  style: TextStyle(fontSize: 20),
                ),
                SizedBox(
                  height: 25,
                ),
                Text(
                  'Quantidade:',
                  style: TextStyle(color: Color(0xFF006400), fontSize: 20),
                ),
                Text(
                  '2000',
                  style: TextStyle(fontSize: 20),
                ),
                SizedBox(
                  height: 25,
                ),
                Text(
                  'Preço:',
                  style: TextStyle(color: Color(0xFF006400), fontSize: 20),
                ),
                Text(
                  'R\$ 90',
                  style: TextStyle(fontSize: 20),
                ),
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
                  'Distância:',
                  style: TextStyle(color: Color(0xFF006400), fontSize: 20),
                ),
                Text(
                  '20 km',
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
