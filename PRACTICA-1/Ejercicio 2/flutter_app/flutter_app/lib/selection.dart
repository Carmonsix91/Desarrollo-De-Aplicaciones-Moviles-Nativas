import 'package:flutter/material.dart';

class SelectionScreen extends StatefulWidget {
  const SelectionScreen({super.key});

  @override
  _SelectionScreenState createState() => _SelectionScreenState();
}

class _SelectionScreenState extends State<SelectionScreen> {
  bool _checkboxValue = false;
  String _radioValue = 'Opción 1';
  bool _switchValue = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Elementos de Selección'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text(
              'Elementos de Selección',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),
            // Checkbox
            Row(
              children: [
                Checkbox(
                  value: _checkboxValue,
                  onChanged: (value) {
                    setState(() {
                      _checkboxValue = value!;
                    });
                  },
                ),
                const Text('Checkbox - Selección múltiple'),
              ],
            ),
            const SizedBox(height: 16),
            // RadioButtons
            const Text('RadioButtons - Selección única:'),
            Column(
              children: [
                RadioListTile(
                  title: const Text('Opción 1'),
                  value: 'Opción 1',
                  groupValue: _radioValue,
                  onChanged: (value) {
                    setState(() {
                      _radioValue = value.toString();
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('Opción 2'),
                  value: 'Opción 2',
                  groupValue: _radioValue,
                  onChanged: (value) {
                    setState(() {
                      _radioValue = value.toString();
                    });
                  },
                ),
                RadioListTile(
                  title: const Text('Opción 3'),
                  value: 'Opción 3',
                  groupValue: _radioValue,
                  onChanged: (value) {
                    setState(() {
                      _radioValue = value.toString();
                    });
                  },
                ),
              ],
            ),
            const SizedBox(height: 16),
            // Switch
            Row(
              children: [
                Switch(
                  value: _switchValue,
                  onChanged: (value) {
                    setState(() {
                      _switchValue = value;
                    });
                  },
                ),
                const Text('Switch - Activado/Desactivado'),
              ],
            ),
            const SizedBox(height: 16),
            const Text(
              'Los elementos de selección permiten al usuario elegir entre diferentes opciones. Checkbox para selecciones múltiples, RadioButton para una única selección, y Switch para alternar entre dos estados.',
            ),
            const SizedBox(height: 16),
            Text('Checkbox: ${_checkboxValue ? "Seleccionado" : "No seleccionado"}'),
            Text('Opción seleccionada: $_radioValue'),
            Text('Switch: ${_switchValue ? "Activado" : "Desactivado"}'),
          ],
        ),
      ),
    );
  }
}