data = readtable('Results.csv');

linkedData = data(strcmp(data.Structure,'LinkedList'),:);

figure

plot(linkedData.Size,linkedData.Insertion,'-o')
hold on

plot(linkedData.Size,linkedData.Bubble,'-o')

plot(linkedData.Size,linkedData.Merge,'-o')

plot(linkedData.Size,linkedData.BuiltIn,'-o')

xlabel('Dataset Size')

ylabel('Runtime (ns)')

title('LinkedList Performance')

legend('Insertion','Bubble','Merge','Built-In')

grid on