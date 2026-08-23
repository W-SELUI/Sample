clc;
clear;
close all;

data = readtable('StructureStatistics.csv');

figure;

bar(categorical(data.Algorithm), ...
    [data.ArrayListMean data.LinkedListMean]);

xlabel('Algorithm');
ylabel('Mean Runtime (ns)');
title('Impact of ArrayList vs LinkedList on Sorting Performance');

legend('ArrayList', ...
       'LinkedList', ...
       'Location', 'northwest');

grid on;

saveas(gcf,'DataStructureImpactGraph.png');