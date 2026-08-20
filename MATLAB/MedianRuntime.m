data = readtable('StatisticsResults.csv');

insertion = data(strcmp(data.Algorithm,'Insertion'),:);
bubble = data(strcmp(data.Algorithm,'Bubble'),:);
merge = data(strcmp(data.Algorithm,'Merge'),:);
builtin = data(strcmp(data.Algorithm,'BuiltIn'),:);

figure

plot(insertion.Size,insertion.Median,'-o')
hold on

plot(bubble.Size,bubble.Median,'-o')

plot(merge.Size,merge.Median,'-o')

plot(builtin.Size,builtin.Median,'-o')

xlabel('Dataset Size')
ylabel('Median Runtime (ns)')

title('Median Runtime vs Dataset Size')

legend('Insertion','Bubble','Merge','Built-In')

grid on