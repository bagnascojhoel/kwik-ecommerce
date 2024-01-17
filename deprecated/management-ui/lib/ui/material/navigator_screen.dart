import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:kwik_ecommerce_management_ui/ui/material/home_screen.dart';
import 'package:kwik_ecommerce_management_ui/ui/material/product/product_screen.dart';

class MaterialNavigatorScreen extends StatefulWidget {
  @override
  State<MaterialNavigatorScreen> createState() {
    return _MaterialNavigatorScreenState();
  }
}

class _MaterialNavigatorScreenState extends State<MaterialNavigatorScreen> {
  static const int _bottomNavigationBarBreakpoint = 500;
  static const int _expandedRailNavigationBreakpoint = 800;

  int _currentScreenIndex = 0;

  void _handleDestinationSelected(int screenIndex) {
    setState(() {
      _currentScreenIndex = screenIndex;
    });
  }

  @override
  Widget build(BuildContext context) {
    Widget currentPage;

    switch (_currentScreenIndex) {
      case 0:
        currentPage = ProductScreen();
        break;
      case 1:
        currentPage = HomeScreen();
        break;
      default:
        throw UnimplementedError("Page $_currentScreenIndex does not exist");
    }

    return LayoutBuilder(builder: (context, constraints) {
      return Scaffold(
        bottomNavigationBar:
            constraints.maxWidth <= _bottomNavigationBarBreakpoint
                ? _BottomNavigationBar(
                    _handleDestinationSelected, _currentScreenIndex)
                : null,
        body: Row(
          children: [
            if (constraints.maxWidth > _bottomNavigationBarBreakpoint)
              _RailNavigation(
                  constraints.maxWidth >= _expandedRailNavigationBreakpoint,
                  _currentScreenIndex,
                  _handleDestinationSelected),
            Expanded(
                child: Container(
                    color: Theme.of(context).canvasColor, child: currentPage))
          ],
        ),
      );
    });
  }
}

class _BottomNavigationBar extends StatelessWidget {
  final ValueChanged<int> onDestinationSelected;
  final int selectedIndex;

  const _BottomNavigationBar(this.onDestinationSelected, this.selectedIndex);

  @override
  Widget build(BuildContext context) {
    return NavigationBar(
      destinations: [
        NavigationDestination(
            icon: Icon(Icons.shopping_basket),
            label: AppLocalizations.of(context)!.products),
        NavigationDestination(
            icon: Icon(Icons.home),
            label: AppLocalizations.of(context)!.appTitle),
      ],
      onDestinationSelected: onDestinationSelected,
      selectedIndex: selectedIndex,
    );
  }
}

class _RailNavigation extends StatelessWidget {
  final bool extended;
  final int selectedIndex;
  final ValueChanged<int> onDestinationSelected;

  const _RailNavigation(
      this.extended, this.selectedIndex, this.onDestinationSelected);

  @override
  Widget build(BuildContext context) {
    return SafeArea(
        child: NavigationRail(
      extended: extended,
      destinations: [
        NavigationRailDestination(
            icon: Icon(Icons.shopping_basket),
            label: Text(AppLocalizations.of(context)!.products)),
        NavigationRailDestination(
            icon: Icon(Icons.home),
            label: Text(AppLocalizations.of(context)!.appTitle)),
      ],
      selectedIndex: selectedIndex,
      onDestinationSelected: onDestinationSelected,
    ));
  }
}
