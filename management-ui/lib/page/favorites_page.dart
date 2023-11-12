import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:kwik_ecommerce_management_ui/shared_state/idea_state.dart';
import 'package:provider/provider.dart';

class FavoritesPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final ideaState = context.watch<IdeaState>();
    final theme = Theme.of(context);

    return ListView.builder(
        itemCount: ideaState.favorites.length,
        itemBuilder: (context, index) {
          final favorite = ideaState.favorites.elementAt(index);

          return GestureDetector(
            onTap: () => ideaState.removeFavorite(favorite),
            child: Container(
            decoration: BoxDecoration(
                borderRadius: BorderRadius.all(Radius.circular(6)),
                color: theme.primaryColor
            ),
            margin: EdgeInsets.symmetric(horizontal: 30, vertical: 5),
            child: Padding(
              padding: EdgeInsets.all(20),
              child: Text(
                    textAlign: TextAlign.center,
                    style: theme.textTheme.titleLarge?.copyWith(color: theme.colorScheme.onPrimary),
                    favorite.asPascalCase,
                    semanticsLabel: "${favorite.first} ${favorite.second}",
                ),
              ),
            ),
          );
        },
    );
  }

}