data = readtable('Results.csv');

arrayData = data(strcmp(data.Structure,'ArrayList'),:);
linkedData = data(strcmp(data.Structure,'LinkedList'),:);

figure

plot(arrayData.Size,arrayData.Merge,'-o')
hold on

plot(linkedData.Size,linkedData.Merge,'-o')

xlabel('Dataset Size')

ylabel('Runtime (ns)')

title('Merge Sort: ArrayList vs LinkedList')

legend('ArrayList','LinkedList')

grid on