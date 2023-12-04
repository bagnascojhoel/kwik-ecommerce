import 'package:get/get.dart';
import 'package:kwik_ecommerce_management_ui/domain/product.dart';
import 'package:kwik_ecommerce_management_ui/domain/product_repository.dart';

class ProductController extends GetxController with StateMixin<List<Product>> {
  final ProductRepository productRepository;

  ProductController({required this.productRepository});

  @override
  void onInit() {
    loadProducts();
    super.onInit();
  }

  void loadProducts() {
    change(state, status: RxStatus.loading());
    append(() => fetchProducts, errorMessage: "Error loading products");
  }

  Future<List<Product>> fetchProducts() async {
    return await productRepository.findProducts();
  }
}
