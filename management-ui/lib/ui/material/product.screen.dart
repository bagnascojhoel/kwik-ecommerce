import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:kwik_ecommerce_management_ui/domain/product.dart';

class ProductScreen extends StatefulWidget {
  @override
  State<ProductScreen> createState() => _ProductScreenState();
}

class _ProductScreenState extends State<ProductScreen> {
  final Set<Product> products = {Product(id: "", name: "douglas")};

  void navigateToRenderProduct() {

  }

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: Column(
        children: [
          Padding(
              padding: EdgeInsets.only(top: 10, left: 5, right: 5, bottom: 30),
              child: SearchBar(
                elevation: MaterialStateProperty.all(1),
                padding: MaterialStateProperty.all(EdgeInsets.symmetric(vertical: 5, horizontal: 10)),
                leading: Icon(Icons.search),
                hintText: "Search",
              )
          )
        ],
      ),
    );
    // return Expanded(
    //     child: Column(
    //       children: [
    //         Row(
    //           children: [SearchBar(), IconButton(onPressed: navigateToRenderProduct, icon: Icon(Icons.add))],
    //         ),
    //         ListView(
    //           children: products.map((p) => Text(p.name)).toList(),
    //         )
    //       ],
    //   )
    // );
  }

}