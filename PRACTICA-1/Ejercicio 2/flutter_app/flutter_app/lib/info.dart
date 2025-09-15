import 'package:flutter/material.dart';

class InformationScreen extends StatefulWidget {
  const InformationScreen({super.key});

  @override
  _InformationScreenState createState() => _InformationScreenState();
}

class _InformationScreenState extends State<InformationScreen> {
  double _progress = 0.5;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Elementos de Información'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text(
              'Elementos de Información',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),
            const Text('Este es un Texto estático (equivalente a TextView)'),
            const SizedBox(height: 16),
            Image.network(
              'https://flutter.github.io/assets-for-api-docs/assets/widgets/owl-2.jpg',
              height: 100,
              errorBuilder: (context, error, stackTrace) => const Icon(Icons.error),
            ),
            const SizedBox(height: 16),
            LinearProgressIndicator(value: _progress),
            const SizedBox(height: 16),
            Slider(
              value: _progress,
              onChanged: (value) {
                setState(() {
                  _progress = value;
                });
              },
            ),
            const SizedBox(height: 16),
            const Text(
              'TextView: muestra texto. ImageView: muestra imágenes. ProgressBar: indica progreso.',
            ),
          ],
        ),
      ),
    );
  }
}