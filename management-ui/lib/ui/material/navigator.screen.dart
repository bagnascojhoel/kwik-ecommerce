import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:kwik_ecommerce_management_ui/ui/material/favorites_page.dart';
import 'package:kwik_ecommerce_management_ui/ui/material/home_page.dart';

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

  void _handleScreenSelected(int screenIndex) {
    setState(() {
      _currentScreenIndex = screenIndex;
    });
  }

  @override
  Widget build(BuildContext context) {
    Widget currentPage;

    switch (_currentScreenIndex) {
      case 0:
        currentPage = HomePage();
        break;
      case 1:
        currentPage = FavoritesPage();
        break;
      default:
        throw UnimplementedError("Page $_currentScreenIndex does not exist");
    }

     return LayoutBuilder(
         builder: (context, constraints) {
           return Scaffold(
             bottomNavigationBar: constraints.maxWidth <= _bottomNavigationBarBreakpoint
                 ? _BottomNavigationBar(_handleScreenSelected, _currentScreenIndex)
                 : null,
             body: Row(
               children: [
                 if (constraints.maxWidth > _bottomNavigationBarBreakpoint)
                   _RailNavigation(constraints.maxWidth >= _expandedRailNavigationBreakpoint, _currentScreenIndex, _handleScreenSelected),
                 Expanded(
                     child: Container(
                         color: Theme.of(context).canvasColor,
                         child: currentPage
                     )
                 )
               ],
             ),
           );
         }
     );
  }

}

class _BottomNavigationBar extends StatelessWidget {
  final ValueChanged<int> onDestinationSelected;
  final int selectedIndex;

  const _BottomNavigationBar(this.onDestinationSelected, this.selectedIndex);

  @override
  Widget build(BuildContext context) {
    return  NavigationBar(
          destinations: [
            NavigationDestination(icon: Icon(Icons.home), label: "Home"),
            NavigationDestination(icon: Icon(Icons.favorite), label: "Favorites")
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
                icon: Icon(Icons.home),
                label: Text("Home")
            ),
            NavigationRailDestination(
                icon: Icon(Icons.favorite),
                label: Text("Favorites")
            )
          ],
          selectedIndex: selectedIndex,
          onDestinationSelected: onDestinationSelected,
        )
    );
  }
}