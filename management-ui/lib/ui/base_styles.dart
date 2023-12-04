import 'package:intl/intl.dart';

class BaseInsets {
  static const double gutter = 15;
}

class Currency {
  static String formatAsBrl(double value) {
    return NumberFormat.currency(locale: 'pt_BR').format(value);
  }
}
