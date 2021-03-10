import 'package:ff_navigation_bar/ff_navigation_bar.dart';
import 'package:flutter/material.dart';
import 'package:hackathon/detalhes.dart';
import 'package:hackathon/perfil.dart';

class MainPage extends StatelessWidget {
  int changeIndex(BuildContext context, int index) {
    int selectedIndex = 0;
    switch (index) {
      case 0:
        break;
      case 1:
        break;
      case 2:
        Navigator.push(
            context, MaterialPageRoute(builder: (context) => PerfilPage()));
    }
  }

  Widget escolheNome(int index) {
    if (index % 2 == 0) {
      return Text('Banana');
    } else
      return Text('Maça');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF006400),
      appBar: AppBar(
        title: Text('Agricultor', style: TextStyle(color: Color(0xFF006400))),
        iconTheme: IconThemeData(
          color: Color(0xFF006400),
        ),
        bottomOpacity: 0.0,
        elevation: 0.0,
      ),
      bottomNavigationBar: FFNavigationBar(
        selectedIndex: 1,
        onSelectTab: (index) => changeIndex(context, index),
        items: [
          FFNavigationBarItem(
            iconData: Icons.home,
            label: 'Iniciar',
          ),
          FFNavigationBarItem(
            iconData: Icons.add,
            label: 'Cadastrar',
          ),
          FFNavigationBarItem(
            iconData: Icons.people,
            label: 'Perfil',
          ),
        ],
        theme: FFNavigationBarTheme(
            itemWidth: 60,
            barHeight: 70,
            barBackgroundColor: Theme.of(context).primaryColor,
            unselectedItemIconColor: Color(0xFF006400),
            unselectedItemLabelColor: Color(0xFF006400),
            selectedItemBorderColor: Color(0xFF006400),
            selectedItemIconColor: Color(0xFF006400),
            selectedItemBackgroundColor: Theme.of(context).primaryColor,
            selectedItemLabelColor: Colors.black),
      ),
      body: SingleChildScrollView(
        child: Column(
          children: <Widget>[
            Container(
              padding: EdgeInsets.only(left: 8),
              // margin: EdgeInsets.only(right: 5, left: 5, top: 8, bottom: 12),
              height: 70,
              width: double.infinity,
              decoration: BoxDecoration(
                color: Colors.white,
                // borderRadius: BorderRadius.circular(8),
              ),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
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
                ],
              ),
            ),
            SizedBox(
              height: 10,
            ),
            Padding(
              padding: const EdgeInsets.all(12.0),
              child: ListView.separated(
                separatorBuilder: (context, index) => SizedBox(
                  height: 30,
                ),
                shrinkWrap: true,
                itemCount: 5,
                itemBuilder: (context, index) {
                  return InkWell(
                    onTap: () => Navigator.push(
                        context,
                        MaterialPageRoute(
                            builder: (context) => DetalhesPage())),
                    child: Container(
                      height: 80,
                      color: Colors.white,
                      width: double.infinity,
                      child: ListTile(
                        leading: Container(
                          height: 40,
                          width: 40,
                          decoration: BoxDecoration(
                            image: DecorationImage(
                              image: NetworkImage(
                                  "https://s2.glbimg.com/7inpIUNcR9cTFdKl4Ib-lEZBToM=/0x0:724x483/984x0/smart/filters:strip_icc()/s.glbimg.com/es/ge/f/original/2019/05/15/frutas_variadas_nao_engordam.jpg"),
                            ),
                          ),
                        ),
                        title: Text('Frutas'),
                        subtitle: escolheNome(index),
                        isThreeLine: true,
                        trailing: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: <Widget>[
                            Text('Quantidade: 100'),
                            Text('Preço: 2,50')
                          ],
                        ),
                      ),
                    ),
                  );
                },
              ),
            )
          ],
        ),
      ),
    );
  }
}
