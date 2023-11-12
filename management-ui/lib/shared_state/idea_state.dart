
import 'package:english_words/english_words.dart';
import 'package:flutter/cupertino.dart';

class IdeaState extends ChangeNotifier {
  late WordPair currentIdea = WordPair.random();

  void changeIdea() {
    currentIdea = WordPair.random();
    notifyListeners();
  }

  final Set<WordPair> favorites = {};

  void toggleFavorite() {
    if (!favorites.contains(currentIdea)) {
      favorites.add(currentIdea);
    } else {
      favorites.remove(currentIdea);
    }

    notifyListeners();
  }

  void removeFavorite(WordPair wordPair) {
    favorites.remove(wordPair);

    notifyListeners();
  }
}