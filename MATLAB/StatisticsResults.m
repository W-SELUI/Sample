data = readtable('StatisticsResults.csv');

insertion = data(strcmp(data.Algorithm,'Insertion'),:);
bubble = data(strcmp(data.Algorithm,'Bubble'),:);
merge = data(strcmp(data.Algorithm,'Merge'),:);
builtin = data(strcmp(data.Algorithm,'BuiltIn'),:);

figure

plot(insertion.Size,insertion.Mean,'-o')
hold on

plot(bubble.Size,bubble.Mean,'-o')

plot(merge.Size,merge.Mean,'-o')

plot(builtin.Size,builtin.Mean,'-o')

xlabel('Dataset Size')
ylabel('Mean Runtime (ns)')

title('Mean Runtime vs Dataset Size')

legend('Insertion','Bubble','Merge','Built-In')

grid on