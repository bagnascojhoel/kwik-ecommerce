import 'package:english_words/english_words.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (context) => MyAppState(),
      child: MaterialApp(
        title: 'Namer App',
        theme: ThemeData(
          useMaterial3: true,
          colorScheme: ColorScheme.fromSeed(seedColor: Color(0xFFF97316))
              .copyWith(primary: Color(0xFFF97316)),
        ),
        home: MyHomePage(),
      ),
    );
  }
}

class MyAppState extends ChangeNotifier {
  late WordPair currentIdea = WordPair.random();

  void changeIdea() {
    currentIdea = WordPair.random();
    notifyListeners();
  }
}

class MyHomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    var appState = context.watch<MyAppState>();
    var idea = appState.currentIdea;

    final theme = Theme.of(context);
    final textStyle = theme.textTheme.displayMedium!
        .copyWith(color: theme.colorScheme.primary);

    return Scaffold(
      body: Column(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          Text(
            'Dangerously generated idea:',
            textAlign: TextAlign.center,
            style: textStyle,
          ),
          Idea(idea: idea),
          Wrap(
            alignment: WrapAlignment.center,
            children: [
              ElevatedButton(
                  onPressed: appState.changeIdea, child: Text('Change Idea'))
            ],
          )
        ],
      ),
    );
  }
}

class Idea extends StatelessWidget {
  const Idea({
    super.key,
    required this.idea,
  });

  final WordPair idea;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);

    final textStyle = theme.textTheme.displaySmall!
        .copyWith(color: theme.colorScheme.onPrimary);

    return Card(
      elevation: 2,
      color: theme.colorScheme.primary,
      margin: EdgeInsets.symmetric(horizontal: 50),
      child: Padding(
        padding: const EdgeInsets.all(20),
        child: Text(
          idea.asPascalCase,
          style: textStyle,
          textAlign: TextAlign.center,
          semanticsLabel: "${idea.first} ${idea.second}",
        ),
      ),
    );
  }
}
