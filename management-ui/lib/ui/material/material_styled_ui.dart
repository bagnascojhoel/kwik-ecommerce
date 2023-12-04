import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:kwik_ecommerce_management_ui/ui/material/navigator_screen.dart';
import 'package:kwik_ecommerce_management_ui/ui/theme.dart';
import 'package:provider/provider.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';

// TODO: Change this to use GetMaterialApp and Bindings
class MaterialStyledUi extends StatelessWidget {
  const MaterialStyledUi({super.key});

  @override
  Widget build(BuildContext context) {

    return SafeArea(child:
    MaterialApp(
        locale: Locale('pt'),
        onGenerateTitle: (context) => AppLocalizations.of(context)!.appTitle,
        localizationsDelegates: AppLocalizations.localizationsDelegates,
        supportedLocales: AppLocalizations.supportedLocales,
        theme: ThemeData(
            useMaterial3: true,
            colorScheme: ColorScheme.fromSeed(seedColor: Color(KwikEcommerceTheme.primary))
        ),
        home: MaterialNavigatorScreen()
    )
    );
  }
}