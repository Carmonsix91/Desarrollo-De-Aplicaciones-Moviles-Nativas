import 'package:flutter/material.dart';

class TextFieldsScreen extends StatefulWidget {
  const TextFieldsScreen({super.key});

  @override
  _TextFieldsScreenState createState() => _TextFieldsScreenState();
}

class _TextFieldsScreenState extends State<TextFieldsScreen> {
  String _text = '';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('TextFields'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text(
              'TextFields',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),
            TextField(
              onChanged: (value) {
                setState(() {
                  _text = value;
                });
              },
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                labelText: 'Escribe algo',
              ),
            ),
            const SizedBox(height: 16),
            const Text(
              'Los TextFields permiten al usuario ingresar y editar texto. Son esenciales para formularios y entradas de datos.',
            ),
            const SizedBox(height: 16),
            Text('Texto ingresado: $_text'),
          ],
        ),
      ),
    );
  }
}