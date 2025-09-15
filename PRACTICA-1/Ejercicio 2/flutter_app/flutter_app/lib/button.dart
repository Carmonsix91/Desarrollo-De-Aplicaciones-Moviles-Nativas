import 'package:flutter/material.dart';

class ButtonsScreen extends StatefulWidget {
  const ButtonsScreen({super.key});

  @override
  _ButtonsScreenState createState() => _ButtonsScreenState();
}

class _ButtonsScreenState extends State<ButtonsScreen> {
  int _count = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Botones'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text(
              'Botones',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),
            ElevatedButton(
              onPressed: () {
                setState(() {
                  _count++;
                });
              },
              child: Text('Contador: $_count'),
            ),
            const SizedBox(height: 8),
            IconButton(
              icon: const Icon(Icons.favorite),
              onPressed: () {
                setState(() {
                  _count--;
                });
              },
            ),
            const SizedBox(height: 16),
            const Text(
              'Los botones permiten realizar acciones. ElevatedButton es un botón elevado e IconButton permite usar iconos como acciones.',
            ),
          ],
        ),
      ),
    );
  }
}