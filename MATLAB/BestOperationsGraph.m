clc;
clear;
close all;

data = readtable('CounterStatistics.csv');

algorithms = {'Insertion', 'Bubble', 'Merge'};

figure;
hold on;

for i = 1:length(algorithms)

    algorithmData = ...
        data(strcmp(data.Algorithm, algorithms{i}), :);

    plot(algorithmData.Size, ...
         algorithmData.Best, ...
         '-o', ...
         'LineWidth', 2, ...
         'MarkerSize', 8);

end

xlabel('Dataset Size');
ylabel('Best Operations');
title('Best Operations vs Dataset Size');

legend(algorithms, ...
       'Location', 'northwest');

grid on;

saveas(gcf,'BestOperationsGraph.png');