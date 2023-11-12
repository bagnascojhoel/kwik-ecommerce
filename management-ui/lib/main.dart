import 'package:flutter/material.dart';
import 'package:kwik_ecommerce_management_ui/page/favorites_page.dart';
import 'package:kwik_ecommerce_management_ui/page/home_page.dart';
import 'package:kwik_ecommerce_management_ui/shared_state/idea_state.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  int selectedPageIndex = 0;

  @override
  Widget build(BuildContext context) {

    Widget currentPage;

    switch (selectedPageIndex) {
      case 0:
        currentPage = HomePage();
        break;
      case 1:
        currentPage = FavoritesPage();
        break;
      default:
        throw UnimplementedError("Page $selectedPageIndex does not exist");
    }

    return ChangeNotifierProvider(
      create: (context) => IdeaState(),
      child: MaterialApp(
        title: 'Namer App',
        theme: ThemeData(
          useMaterial3: true,
          colorScheme: ColorScheme.fromSeed(seedColor: Color(0xFFF97316))
              .copyWith(primary: Color(0xFFF97316)),
        ),
        home: LayoutBuilder(
            builder: (context, constraints) {
              return Scaffold(
                body: Row(
                  children: [
                    SafeArea(
                        child: NavigationRail(
                          extended: constraints.maxWidth >= 800,
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
                          selectedIndex: selectedPageIndex,
                          onDestinationSelected: (value) {
                            setState(() {
                              selectedPageIndex = value;
                            });
                          },
                        )
                    ),
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
        ),
      ),
    );
  }
}

