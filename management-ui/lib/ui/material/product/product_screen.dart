import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:kwik_ecommerce_management_ui/controllers/product_controller.dart';
import 'package:kwik_ecommerce_management_ui/domain/product.dart';
import 'package:kwik_ecommerce_management_ui/ui/base_styles.dart';

class ProductScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.all(BaseInsets.gutter),
      child: Row(
        children: [Expanded(flex: 5, child: ManagementColumn())],
      ),
    );
  }

  ProductScreen() {
    Get.put(ProductController(productRepository: Get.find()));
  }
}

class ManagementColumn extends StatelessWidget {
  final ProductController productController = Get.find();

  void onCreateProduct() {}

  void onToggleShowArchived(bool value) {}

  @override
  Widget build(BuildContext context) {
    productController.loadProducts();
    return Column(children: [
      Row(
        children: [
          SearchBar(),
          ElevatedButton(onPressed: onCreateProduct, child: Text("Add product"))
        ],
      ),
      Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Row(
            children: [
              Switch(
                value: false,
                onChanged: onToggleShowArchived,
              ),
              Text("Show archived products")
            ],
          ),
          ElevatedButton(
              onPressed: productController.loadProducts, child: Text("Refresh"))
        ],
      ),
      SingleChildScrollView(
          scrollDirection: Axis.vertical,
          child: productController.obx((state) => ProductTable(state!))),
    ]);
  }
}

class RegisterColumn extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Placeholder();
  }
}

class ProductTable extends StatelessWidget {
  final List<Product> products;

  ProductTable(this.products);

  @override
  Widget build(BuildContext context) {
    return DataTable(
      columns: [
        DataColumn(label: Text("Status")),
        DataColumn(label: Text("Nome")),
        DataColumn(label: Text("Preço")),
        DataColumn(label: Text("Descrição")),
        DataColumn(label: Text("Capa"))
      ],
      rows: products
          .map((product) => DataRow(cells: [
                DataCell(Text(product.productState.code)),
                DataCell(Text(product.productName)),
                DataCell(Text(Currency.formatAsBrl(product.priceInBrl))),
                DataCell(Text(product.productDescription)),
                DataCell(Text("")),
              ]))
          .toList(),
    );
  }
}
