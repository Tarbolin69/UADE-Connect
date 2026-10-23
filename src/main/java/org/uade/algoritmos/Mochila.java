package org.uade.algoritmos;

import org.uade.entidades.Iniciativa;

import java.util.ArrayList;
import java.util.List;

public class Mochila {
    // La verdad esta fue la más simple a elejir, ya que es
    // poco más que una variación del problema de la mochila
    // solo que con nombres diferentes.

    // O(n * P)
    public record Resultado(List<Iniciativa> seleccionadas, int costoTotal, int impactoTotal, int presupuestoRestante) {
    }

    public static Resultado seleccionar(List<Iniciativa> iniciativas, int presupuesto) {
        int n = iniciativas.size();
        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            Iniciativa iniciativa = iniciativas.get(i - 1);
            for (int c = 0; c <= presupuesto; c++) {
                if (iniciativa.getCosto() > c) {
                    dp[i][c] = dp[i - 1][c];
                } else {
                    dp[i][c] = Math.max(dp[i - 1][c], dp[i - 1][c - iniciativa.getCosto()] + iniciativa.getImpacto());
                }
            }
        }

        List<Iniciativa> seleccionadas = new ArrayList<>();
        int costoTotal = 0;
        int c = presupuesto;
        for (int i = n; i >= 1; i--) {
            if (dp[i][c] != dp[i - 1][c]) {
                Iniciativa iniciativa = iniciativas.get(i - 1);
                seleccionadas.add(iniciativa);
                costoTotal += iniciativa.getCosto();
                c -= iniciativa.getCosto();
            }
        }

        int impactoTotal = dp[n][presupuesto];
        int presupuestoRestante = presupuesto - costoTotal;
        return new Resultado(seleccionadas, costoTotal, impactoTotal, presupuestoRestante);
    }
}
