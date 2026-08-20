data = readtable('Results.csv');

arrayData = data(strcmp(data.Structure,'ArrayList'),:);

figure;

plot(arrayData.Size,arrayData.Insertion,'-o');
hold on;
plot(arrayData.Size,arrayData.Bubble,'-o');
plot(arrayData.Size,arrayData.Merge,'-o');
plot(arrayData.Size,arrayData.BuiltIn,'-o');

xlabel('Dataset Size');
ylabel('Runtime (ns)');
title('ArrayList Performance');
legend('Insertion','Bubble','Merge','Built-In');

grid on

shg;
