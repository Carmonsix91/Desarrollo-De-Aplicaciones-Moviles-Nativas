import 'package:flutter/material.dart';

class ListsScreen extends StatelessWidget {
  const ListsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final List<String> items = List.generate(20, (index) => 'Elemento ${index + 1}');

    return Scaffold(
      appBar: AppBar(
        title: const Text('Listas'),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Padding(
            padding: EdgeInsets.all(16.0),
            child: Text(
              'Listas',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
          ),
          Expanded(
            child: ListView.builder(
              itemCount: items.length,
              itemBuilder: (context, index) {
                return ListTile(
                  title: Text(items[index]),
                );
              },
            ),
          ),
          const Padding(
            padding: EdgeInsets.all(16.0),
            child: Text(
              'ListView muestra listas eficientemente renderizando solo los elementos visibles.',
            ),
          ),
        ],
      ),
    );
  }
}