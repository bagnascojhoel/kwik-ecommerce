import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:get/get.dart';
import 'package:kwik_ecommerce_management_ui/ui/material/home_screen.dart';
import 'package:kwik_ecommerce_management_ui/ui/material/product/product_screen.dart';
import 'package:kwik_ecommerce_management_ui/ui/theme.dart';

// TODO: Change this to use GetMaterialApp and Bindings
class MaterialStyledUi extends StatelessWidget {
  const MaterialStyledUi({super.key});

  @override
  Widget build(BuildContext context) {
    return SafeArea(
        child: GetMaterialApp(
      locale: Locale('pt'),
      onGenerateTitle: (context) => AppLocalizations.of(context)!.appTitle,
      localizationsDelegates: AppLocalizations.localizationsDelegates,
      supportedLocales: AppLocalizations.supportedLocales,
      theme: ThemeData(
          useMaterial3: true,
          colorScheme: ColorScheme.fromSeed(
              seedColor: Color(KwikEcommerceTheme.primary))),
      initialRoute: '/product-management',
      getPages: [
        GetPage(name: '/', page: () => HomeScreen()),
        GetPage(name: '/product-management', page: () => ProductScreen())
      ],
    ));
  }
}
// TODO: Add standard project formatting like .editorconfig
