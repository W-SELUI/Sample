figure

plot(insertion.Size,insertion.Worst,'-o')
hold on

plot(bubble.Size,bubble.Worst,'-o')

plot(merge.Size,merge.Worst,'-o')

plot(builtin.Size,builtin.Worst,'-o')

xlabel('Dataset Size')
ylabel('Worst Runtime (ns)')

title('Worst Runtime vs Dataset Size')

legend('Insertion','Bubble','Merge','Built-In')

grid on
