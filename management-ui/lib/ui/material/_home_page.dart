// import 'package:english_words/english_words.dart';
// import 'package:flutter/cupertino.dart';
// import 'package:flutter/material.dart';
// import 'package:kwik_ecommerce_management_ui/shared_state/idea_state.dart';
// import 'package:provider/provider.dart';
//
//
// class HomePage extends StatelessWidget {
//   @override
//   Widget build(BuildContext context) {
//     var appState = context.watch<IdeaState>();
//     var idea = appState.currentIdea;
//
//     final theme = Theme.of(context);
//     final textStyle = theme.textTheme.displayMedium!
//         .copyWith(color: theme.colorScheme.primary);
//
//     IconData icon;
//     if (appState.favorites.contains(idea)) {
//       icon = Icons.favorite;
//     } else {
//       icon = Icons.favorite_border;
//     }
//
//     return Center(
//       child: Column(
//         mainAxisAlignment: MainAxisAlignment.spaceEvenly,
//         children: [
//           Text(
//             'Dangerously Generated Idea',
//             textAlign: TextAlign.center,
//             style: textStyle,
//           ),
//           Idea(idea: idea),
//           Wrap(
//             alignment: WrapAlignment.center,
//             spacing: 20,
//             children: [
//               ElevatedButton.icon(
//                   onPressed: appState.toggleFavorite,
//                   icon: Icon(icon),
//                   label: Text('Favorite')
//               ),
//               ElevatedButton(
//                   onPressed: appState.changeIdea,
//                   child: Text('Change Idea')
//               )
//             ],
//           ),
//         ],
//       ),
//     );
//   }
//
// }
//
// class Idea extends StatelessWidget {
//   const Idea({
//     super.key,
//     required this.idea,
//   });
//
//   final WordPair idea;
//
//   @override
//   Widget build(BuildContext context) {
//     final theme = Theme.of(context);
//
//     final textStyle = theme.textTheme.displaySmall!
//         .copyWith(color: theme.colorScheme.onPrimary);
//
//     return Card(
//       elevation: 2,
//       color: theme.colorScheme.primary,
//       margin: EdgeInsets.symmetric(horizontal: 50),
//       child: Padding(
//         padding: const EdgeInsets.all(20),
//         child: Text(
//           idea.asPascalCase,
//           style: textStyle,
//           textAlign: TextAlign.center,
//           semanticsLabel: "${idea.first} ${idea.second}",
//         ),
//       ),
//     );
//   }
// }
